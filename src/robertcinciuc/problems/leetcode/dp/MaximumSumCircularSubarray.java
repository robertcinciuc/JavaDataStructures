package robertcinciuc.problems.leetcode.dp;

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {

        int sumMax = Integer.MIN_VALUE;
        int sum = 0;

        int sumMin = Integer.MAX_VALUE;
        int sum2 = 0;
        int indexLastMin = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];

            if(sum > sumMax){
                sumMax = sum;
            }

            if(sum < 0){
                sum = 0;
            }

            sum2 += nums[i];
            if(sum2 < sumMin){
                sumMin = sum2;
                indexLastMin = i;
            }
            if(sum2 > 0){
                sum2 = 0;
            }
        }

        int[] nums2 = new int[nums.length];
        for(int i = 0; i < nums.length - indexLastMin - 1; ++i){
            nums2[i] = nums[i + indexLastMin + 1];
        }

        for(int i = nums.length - indexLastMin - 1; i < nums.length; ++i){
            nums2[i] = nums[i - (nums.length - indexLastMin - 1)];
        }

        int sumMax3 = Integer.MIN_VALUE;
        int sum3 = 0;
        for(int i = 0; i < nums2.length; ++i){
            sum3 += nums2[i];

            if(sum3 > sumMax3){
                sumMax3 = sum3;
            }

            if(sum3 < 0){
                sum3 = 0;
            }
        }

        return Math.max(sumMax, sumMax3);
    }

    public static void main(String[] args) {
        var v = new MaximumSumCircularSubarray();
        System.out.println(v.maxSubarraySumCircular(new int[]{5,-3,5}));
        System.out.println(v.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println(v.maxSubarraySumCircular(new int[]{2,-2,2,7,8,0}));
    }

}
