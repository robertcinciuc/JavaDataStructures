package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Set<Map<Integer, Integer>> seen = new HashSet<>();
        Set<Map<Integer, Integer>> resp = new HashSet<>();
        Map<Integer, Integer> current = new HashMap<>();
        for(int candidate: candidates){
            current.put(candidate, 0);
        }

        recursiveSearch(seen, resp, current, 0, candidates, target);

        List<List<Integer>> respFinal = new ArrayList<>();
        for(Map<Integer, Integer> respValues: resp){
            List<Integer> possibility = new ArrayList<>();
            for(Integer val : respValues.keySet()){
                int valFreq = respValues.get(val);
                while(valFreq > 0){
                    possibility.add(val);
                    valFreq--;
                }
            }

            respFinal.add(possibility);
        }

        return respFinal;
    }

    public void recursiveSearch(Set<Map<Integer, Integer>> seen, Set<Map<Integer, Integer>> resp, Map<Integer, Integer> current, int currSum, int[] candidates, int target){
        if(currSum > target){
            return;
        }
        if(currSum == target){
            resp.add(current.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        }

        for(int candidate: candidates){
            current.merge(candidate, 1, Integer::sum);
            if(!seen.contains(current)){
                seen.add(current.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
                recursiveSearch(seen, resp, current, currSum + candidate, candidates, target);
            }
            current.merge(candidate, 1, (prev, v) -> prev - v);
        }
    }

    public static void main(String[] args) {
        var v = new CombinationSum();
        System.out.println(v.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(v.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(v.combinationSum(new int[]{2}, 1));
        System.out.println(v.combinationSum(new int[]{3,2,6,7}, 11));
    }
}
