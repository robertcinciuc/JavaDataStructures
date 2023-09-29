package robertcinciuc.problems.leetcode.backtracking;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {

        return recursiveSearch(nums, target, 0, 0);
    }

    public int recursiveSearch(int[] nums, int target, int index, int currSum){
        if(index == nums.length){
            if(currSum == target){
                return 1;
            }
            return 0;
        }

        int negative = recursiveSearch(nums, target, index + 1, currSum - nums[index]);
        int positive = recursiveSearch(nums, target, index + 1, currSum + nums[index]);

        return negative + positive;
    }

    public static void main(String[] args) {
        var v = new TargetSum();
        System.out.println(v.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
