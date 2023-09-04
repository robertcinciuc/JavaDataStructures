package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> resp = new ArrayList<>();

        Set<String> seen = new HashSet<>();
        Map<Integer, Boolean> left = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        List<Integer> current = new ArrayList<>();

        for(int elem: nums){
            left.put(elem, true);
        }

        recursiveSearch(nums, left, current, seen, resp, sb);

        return resp;
    }

    public void recursiveSearch(int[] nums, Map<Integer, Boolean> left, List<Integer> current, Set<String> seen, List<List<Integer>> resp, StringBuilder sb){
        if(current.size() == nums.length){
            resp.add(List.copyOf(current));
            return;
        }

        for(Integer elem: left.keySet()){
            sb.append(elem);
            if(left.get(elem) && !seen.contains(sb.toString())){
                seen.add(sb.toString());
                left.put(elem, false);
                current.add(elem);
                recursiveSearch(nums, left, current, seen, resp, sb);
                current.remove(current.size() - 1);
                left.put(elem, true);
            }
            sb.delete(sb.length() - String.valueOf(elem).length(), sb.length());
        }
    }

    public static void main(String[] args) {
        var v = new Permutations();
        System.out.println(v.permute(new int[]{1, 2, 3}));
        System.out.println(v.permute(new int[]{0}));
        System.out.println(v.permute(new int[]{0, 1}));
    }
}
