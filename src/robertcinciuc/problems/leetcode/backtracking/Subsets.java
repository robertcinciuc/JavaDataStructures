package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        Set<Set<Integer>> resp = new HashSet<>();
        Map<Integer, Boolean> left = new HashMap<>();
        Set<Integer> current = new TreeSet<>();
        for(int elem: nums){
            left.put(elem, true);
        }

        resp.add(new HashSet<>());
        recursiveSearch(nums, left, resp, current);

        List<List<Integer>> respFinal = new ArrayList<>();
        for(Set<Integer> subResp: resp){
            respFinal.add(new ArrayList<>(subResp));
        }

        return respFinal;

    }

    public void recursiveSearch(int[] nums, Map<Integer, Boolean> left, Set<Set<Integer>> resp, Set<Integer> current){

        if(current.size() == nums.length){
            return;
        }

        for(Integer elem: left.keySet()){
            if(left.get(elem)){
                current.add(elem);
                left.put(elem, false);
                if(!resp.contains(current)){
                    resp.add(new HashSet<>(current));
                    recursiveSearch(nums, left, resp, current);
                }

                left.put(elem, true);
                current.remove(elem);
            }
        }
    }
}
