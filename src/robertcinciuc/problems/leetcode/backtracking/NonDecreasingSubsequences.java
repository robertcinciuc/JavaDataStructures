package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class NonDecreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums == null || nums.length == 0){
            return List.of();
        }

        Set<List<Integer>> seen = new HashSet<>();
        List<Integer> current = new ArrayList<>();
        recursiveSearch(seen, current, -101, -1, 0, nums);

        return new ArrayList<>(seen);
    }

    public void recursiveSearch(Set<List<Integer>> seen, List<Integer> current, int last, int index, int count, int[] nums){
        if(seen.contains(current)){
            return;
        }

        if(!seen.contains(current) && count > 1){
            seen.add(new ArrayList<>(current));
        }

        for(int i = index + 1; i < nums.length; ++i){
            if(nums[i] >= last || last == -101){
                current.add(nums[i]);
                recursiveSearch(seen, current, nums[i], i, count + 1, nums);
                current.remove(current.size() - 1);
            }
        }

    }
}
