package robertcinciuc.problems.leetcode;

public class LongestIncreasingSubsequence {

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
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        System.out.println(obj.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(obj.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(obj.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(obj.lengthOfLIS(new int[]{0}));
    }
}
