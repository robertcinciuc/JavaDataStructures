package robertcinciuc.problems.leetcode.dp;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        int[][] sums = new int[nums.length][nums.length];

        for(int i = 0; i < nums.length; ++i){
            sums[i][i] = nums[i];
        }

        for(int delta = 1; delta < nums.length; ++delta){
            for(int i = 0; i < nums.length; i++){

                if(i + delta < nums.length){

                    int val1 = sums[i][i + delta - 1] + sums[i + delta][i + delta];
                    int val2 = sums[i + 1][i + delta] + sums[i][i];

                    sums[i][i + delta] = Math.max(val1, val2);
                }
            }
        }

        int maxi = sums[0][0];
        for(int i = 0; i < sums.length; ++i){
            for(int j = i; j < sums.length; ++j){
                if(sums[i][j] > maxi){
                    maxi = sums[i][j];
                }
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        var v = new MaximumSubarray();
//        System.out.println(v.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(v.maxSubArray(new int[]{5,4,-1,7,8}));
//        System.out.println(v.maxSubArray(new int[]{1}));
        System.out.println(v.maxSubArray(new int[]{-2, -1}));
    }
}
