package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {

        Set<Set<Integer>> resp = new HashSet<>();
        Set<Integer> elemSoFar = new HashSet<>();
        Set<Integer> used = new TreeSet<>();

        recursiveSearch(resp, elemSoFar, used, 0, k, n, 0, 0);

        List<List<Integer>> respFinal = new ArrayList<>();
        return resp.stream().map(ArrayList::new).collect(Collectors.toList());
    }

    public void recursiveSearch(Set<Set<Integer>> resp, Set<Integer> elemSoFar, Set<Integer> used, int current, int targetCount, int targetSum, int sum, int count){
        if(sum > targetSum || count > targetCount){
            return;
        }

        if(sum == targetSum && count == targetCount){
            resp.add(new HashSet<>(elemSoFar));
        }

        for(int i = current + 1; i <= 9; ++i){
            if(!used.contains(i)){
                used.add(i);
                elemSoFar.add(i);
                recursiveSearch(resp, elemSoFar, used, i, targetCount, targetSum, sum + i, count + 1);
                elemSoFar.remove(i);
                used.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        var v = new CombinationSum3();
        System.out.println(v.combinationSum3(3, 7));
        System.out.println(v.combinationSum3(3, 9));
    }
}
