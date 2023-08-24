package robertcinciuc.problems.leetcode.divideconquer;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        int[] maxi = new int[k];
        boolean[] used = new boolean[nums.length];

        for(int i = 0; i < k; ++i){
            maxi[i] = Integer.MIN_VALUE;
            int index = 0;
            for (int j = 0; j < nums.length; ++j) {
                if (i > 0) {
                    if (nums[j] > maxi[i] && nums[j] <= maxi[i - 1] && !used[j]) {
                        maxi[i] = nums[j];
                        index = j;
                    }
                } else {
                    if (nums[j] > maxi[i] && !used[j]) {
                        maxi[i] = nums[j];
                        index = j;
                    }
                }
            }

            used[index] = true;
        }

        return maxi[k - 1];
    }

    public static void main(String[] args) {
        var v = new KthLargestElementInAnArray();
        System.out.println(v.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(v.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
