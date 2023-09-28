package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class NonDecreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums == null || nums.length == 0){
            return List.of();
        }

        Set<Map<Integer, Integer>> seen = new HashSet<>();
        Map<Integer, Integer> current = new TreeMap<>();
        recursiveSearch(seen, current, -101, -1, 0, nums);

        return transformToResult(seen);
    }

    public void recursiveSearch(Set<Map<Integer, Integer>> seen, Map<Integer, Integer> current, int last, int index, int count, int[] nums){
        if(seen.contains(current)){
            return;
        }

        if(!seen.contains(current) && count > 1){
            seen.add(new TreeMap<>(current));
        }

        for(int i = index + 1; i < nums.length; ++i){
            if(nums[i] >= last || last == -101){
                current.merge(nums[i], 1, Integer::sum);
                recursiveSearch(seen, current, nums[i], i, count + 1, nums);
                current.merge(nums[i], 1, (prev, v) -> prev - v);
            }
        }

    }

    private static List<List<Integer>> transformToResult(Set<Map<Integer, Integer>> seen){
        List<List<Integer>> res = new ArrayList<>();

        for(Map<Integer, Integer> mapy: seen){
            List<Integer> arr = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry: mapy.entrySet()){
                int freq = entry.getValue();
                while(freq > 0){
                    arr.add(entry.getKey());
                    freq--;
                }
            }

            res.add(arr);
        }

        return res;
    }
}
