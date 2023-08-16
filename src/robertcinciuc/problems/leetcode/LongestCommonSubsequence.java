package robertcinciuc.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2){

        List<List<Integer>> twinsFromText1 = new ArrayList<>();
        for(int i = 0; i < text2.length(); ++i){
            twinsFromText1.add(new ArrayList<>());
        }

        for(int i = 0; i < text1.length(); ++i){
            for(int j = 0; j < text2.length(); ++j){
                if(text1.charAt(i) == text2.charAt(j)){
                    twinsFromText1.get(j).add(i);
                }
            }
        }

        List<Integer> filteredArrayList = new ArrayList<>();
        for(int i = 0; i < text2.length(); ++i){
            if(!twinsFromText1.get(i).isEmpty()) {
                for(int j = twinsFromText1.get(i).size() - 1; j >= 0; --j){
                    filteredArrayList.add(twinsFromText1.get(i).get(j));
                }
            }
        }

        int[] ints = filteredArrayList.stream().mapToInt(e -> e).toArray();

        if(ints.length > 0){
            return lengthOfLIS(ints);
        }

        return 0;
    }

    public int lengthOfLIS(int[] nums) {

        int[] subseqSoFar = new int[nums.length];
        subseqSoFar[0] = 1;
        for(int i = 1; i < subseqSoFar.length; ++i){
            subseqSoFar[i] = -1;
        }

        for(int i = 1; i < nums.length; ++i){

            boolean foundSmaller = false;
            int maxSubseq = 0;
            for(int j = 0; j < i; ++j ){
                if(nums[j] < nums[i]){
                    foundSmaller = true;
                    if(subseqSoFar[j] > maxSubseq){
                        maxSubseq = subseqSoFar[j];
                    }
                }
            }

            if(foundSmaller){
                subseqSoFar[i] = maxSubseq + 1;
            }else{
                subseqSoFar[i] = 1;
            }
        }

        int maxSubseq = 0;
        for(int i = 0; i < subseqSoFar.length; ++i){
            if(subseqSoFar[i] > maxSubseq){
                maxSubseq = subseqSoFar[i];
            }
        }

        return maxSubseq;
    }

    public static void main(String[] args){
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        System.out.println(obj.longestCommonSubsequence("abcde", "ace"));
        System.out.println(obj.longestCommonSubsequence("abc", "abc"));
        System.out.println(obj.longestCommonSubsequence("abc", "def"));
        System.out.println(obj.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
        System.out.println(obj.longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
        System.out.println(obj.longestCommonSubsequence("bl", "yby"));
        System.out.println(obj.longestCommonSubsequence("abcba", "abcbcba"));
        System.out.println(obj.longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }
}
