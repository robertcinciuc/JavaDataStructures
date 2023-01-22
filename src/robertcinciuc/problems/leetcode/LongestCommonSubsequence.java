package robertcinciuc.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence0(String text1, String text2) {
        int[] foundPos = new int[text1.length()];
        int[] lens = new int[text1.length()];

        for(int i = 0; i < text1.length(); ++i) {
            if(text1.charAt(0) == text2.charAt(i)){
                foundPos[0] = i;
                lens[0] = 1;
                break;
            }
        }

        for(int i = 0; i < text1.length(); ++i){
            for(int j = 0; j < i; ++j){

                int foundPrevLen = -1;
                int foundSameAtPos = -1;
                for(int k = foundPos[j]; k < text2.length(); ++k){
                    if(text1.charAt(i) == text2.charAt(k)){
                        foundPrevLen = lens[j];
                        foundSameAtPos = k;
                        break;
                    }
                }

                if(foundSameAtPos != -1){
                    if(lens[i] < foundPrevLen + 1){
                        foundPos[i] = foundSameAtPos;
                        lens[i] = foundPrevLen + 1;
                    }
                }else{
                    int foundPosBefore = -1;
                    for(int k = 0; k < foundPos[j]; ++k){
                        if(text1.charAt(i) == text2.charAt(k)){
                            foundPosBefore = k;
                        }
                    }

                    if(foundPosBefore != -1 && lens[i] == 0){
                        lens[i] = 1;
                        foundPos[i] = foundPosBefore;
                    }
                }
            }
        }

        int resp = 0;
        for(int i = 0; i < lens.length; ++i){
            if(lens[i] > resp){
                resp = lens[i];
            }
        }

        return resp;
    }

    public int longestCommonSubsequence(String text1, String text2){

        int[] twinFromText1 = new int[text2.length()];
        for(int i = 0; i < text2.length(); ++i){
            twinFromText1[i] = -1;
        }

        for(int i = 0; i < text1.length(); ++i){
            for(int j = 0; j < text2.length(); ++j){
                if(text1.charAt(i) == text2.charAt(j) && twinFromText1[j] == -1){
                    twinFromText1[j] = i;
                    break;
                }
            }
        }

        List<Integer> filteredArrayList = new ArrayList<>();
        for(int i = 0; i < text2.length(); ++i){
            if(twinFromText1[i] != -1){
                filteredArrayList.add(twinFromText1[i]);
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
    }
}
