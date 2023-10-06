package robertcinciuc.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph.length == 0){
            return List.of();
        }

        List<List<Integer>> seen = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(0);
        recursiveSearch(0, seen, current, graph);

        return seen;
    }

    private void recursiveSearch(int index, List<List<Integer>> seen, List<Integer> current, int[][] graph){
        if(index == graph.length - 1){
            seen.add(new ArrayList<>(current));
            return;
        }

        for(int elem: graph[index]){
            current.add(elem);
            recursiveSearch(elem, seen, current, graph);
            current.remove(current.size() - 1);
        }
    }
}
