package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> resp = new ArrayList<>();

        recursiveSearch(1, n, k, current, resp);

        return resp;
    }

    public void recursiveSearch(int i, int n, int k, List<Integer> current, List<List<Integer>> resp){
        if(k == 0){
            resp.add(List.copyOf(current));
            return;
        }

        if(i > n){
            return;
        }

        recursiveSearch(i + 1, n, k, current, resp);
        current.add(i);
        recursiveSearch(i + 1, n, k - 1, current, resp);
        current.remove(current.size() - 1);
    }
}
