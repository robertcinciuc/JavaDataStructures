package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        Map<Integer, Boolean> left = new HashMap<>();
        for(int i = 1; i <= n; i++){
            left.put(i, true);
        }
        Set<Set<Integer>> seen = new HashSet<>();
        Set<Integer> current = new HashSet<>();
        List<Set<Integer>> resp = new ArrayList<>();

        recursiveSearch(k, left, seen, current, resp);

        List<List<Integer>> respFinal = new ArrayList<>();
        for(Set<Integer> subResp: resp){
            respFinal.add(new ArrayList<>(subResp));
        }

        return respFinal;
    }

    public void recursiveSearch(int k, Map<Integer, Boolean> left, Set<Set<Integer>> seen, Set<Integer> current, List<Set<Integer>> resp){
        if(current.size() == k){
            resp.add(new HashSet<>(current));
            return;
        }

        for(Integer elem : left.keySet()){
            if(left.get(elem)){
                current.add(elem);
                left.put(elem, false);
                if(!seen.contains(current)){
                    seen.add(new HashSet<>(current));
                    recursiveSearch(k, left, seen, current, resp);
                }
                current.remove(elem);
                left.put(elem, true);
            }
        }
    }
}
