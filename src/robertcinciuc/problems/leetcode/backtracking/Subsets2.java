package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Set<Map<Integer, Integer>> resp = new HashSet<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> current = new HashMap<>();
        for(int elem: nums){
            left.merge(elem, 1, Integer::sum);
            current.put(elem, 0);
        }

        resp.add(new HashMap<>());
        recursiveSearch(left, resp, current);

        List<List<Integer>> respFinal = new ArrayList<>();
        for(Map<Integer, Integer> subResp: resp){
            List<Integer> tmpResp = new ArrayList<>();

            for(Integer key : subResp.keySet()){
                Integer freq = subResp.get(key);
                while(freq > 0){
                    tmpResp.add(key);
                    freq--;
                }
            }
            respFinal.add(tmpResp);
        }

        return respFinal;

    }

    public void recursiveSearch(Map<Integer, Integer> left, Set<Map<Integer, Integer>> resp, Map<Integer, Integer> current){
        for(Integer elem: left.keySet()){
            if(left.get(elem) > 0){
                current.merge(elem, 1, Integer::sum);
                left.merge(elem, 1, (prev, v) -> prev - v);
                if(!resp.contains(current)){
                    resp.add(new HashMap<>(current));
                    recursiveSearch(left, resp, current);
                }

                left.merge(elem, 1, Integer::sum);
                current.merge(elem, 1, (prev, v) -> prev - v);
            }
        }
    }
}
