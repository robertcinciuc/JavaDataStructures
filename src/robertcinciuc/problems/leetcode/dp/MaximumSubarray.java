package robertcinciuc.problems.leetcode.dp;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        var v = new MaximumSubarray();
        System.out.println(v.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(v.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(v.maxSubArray(new int[]{1}));
        System.out.println(v.maxSubArray(new int[]{-2, -1}));
        System.out.println(v.maxSubArray(new int[]{-2,-3,-1}));
    }
}
