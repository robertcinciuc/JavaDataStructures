package robertcinciuc.problems.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        List<List<Integer>> sums = new ArrayList<>();
        for(int i = 0; i < triangle.size(); ++i){
            sums.add(new ArrayList<>());
            for(int j = 0; j < triangle.get(i).size(); ++j){
                sums.get(i).add(Integer.MAX_VALUE);
            }
        }

        return recursiveSearch(0, 0, triangle, sums);
    }

    public int recursiveSearch(int i, int j, List<List<Integer>> triangle, List<List<Integer>> sums){
        if(i >= triangle.size() ){
            return 0;
        }

        if(j >= triangle.get(i).size()){
            return 0;
        }

        if(sums.get(i).get(j) != Integer.MAX_VALUE){
            return sums.get(i).get(j);
        }

        int d = recursiveSearch(i + 1, j, triangle, sums);
        int r = recursiveSearch(i + 1, j + 1, triangle, sums);

        int sum = triangle.get(i).get(j) + Math.min(d, r);
        sums.get(i).set(j, sum);
        return sum;
    }

    public static void main(String[] args) {
        var v = new Triangle();

        System.out.println(v.minimumTotal(new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(2),
                        Arrays.asList(3, 4),
                        Arrays.asList(6, 5, 7),
                        Arrays.asList(4, 1, 8, 3)
                ))));
        System.out.println(v.minimumTotal(new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(-1),
                        Arrays.asList(-2, -3)
                ))));
    }

}
