package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> resp = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);

        recursiveSearch(resp, current, 0, candidates, target, 0);

        return resp;
    }

    public void recursiveSearch(List<List<Integer>> resp, List<Integer> current, int currSum, int[] candidates, int target, int pos){
        if(currSum > target){
            return;
        }
        if(currSum == target){
            resp.add(List.copyOf(current));
        }

        for(int i = pos; i < candidates.length; ++i){
            current.add(candidates[i]);
            recursiveSearch(resp, current, currSum + candidates[i], candidates, target, i);
            current.remove(current.size() - 1);
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
