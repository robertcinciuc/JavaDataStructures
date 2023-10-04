package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        boolean[] used = new boolean[nums.length];

        if (sum % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        return recursiveSearch(nums, k, 0, 0, used, sum / k);
    }

    private boolean recursiveSearch(int[] nums, int k, int currSum, int idx, boolean[] used, int target) {
        if (k == 1) {
            return true;
        }

        if (currSum == target) {
            return recursiveSearch(nums, k - 1, 0, 0, used, target);
        }

        for (int i = idx; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            if (recursiveSearch(nums, k, currSum + nums[i], i + 1, used, target)) {
                return true;
            }
            used[i] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        var v = new PartitionToKEqualSumSubsets();
        System.out.println(v.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4));
        System.out.println(v.canPartitionKSubsets(new int[]{1,2,3,4}, 3));
    }
}
