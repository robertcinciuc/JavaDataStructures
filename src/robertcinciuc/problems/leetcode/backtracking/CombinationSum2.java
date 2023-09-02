package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> resp = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        StringBuilder sb = new StringBuilder();
        Set<String> seen = new HashSet<>();

        recursiveSearch(resp, current, 0, candidates, target, 0, sb, seen);

        return resp;
    }

    public void recursiveSearch(List<List<Integer>> resp, List<Integer> current, int currSum, int[] candidates,
                                int target, int pos, StringBuilder sb, Set<String> seen){
        if(currSum > target){
            return;
        }
        if(currSum == target){
            resp.add(List.copyOf(current));
        }

        for(int i = pos; i < candidates.length; ++i){
            current.add(candidates[i]);
            sb.append(candidates[i]);
            if(!seen.contains(sb.toString())){
                seen.add(sb.toString());
                recursiveSearch(resp, current, currSum + candidates[i], candidates, target, i + 1, sb, seen);
            }
            current.remove(current.size() - 1);
            sb.delete(sb.length() - String.valueOf(candidates[i]).length() , sb.length());
        }
    }

    public static void main(String[] args) {
        var v = new CombinationSum2();
        System.out.println(v.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
