package robertcinciuc.problems.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        Map<String, Integer> sums = new HashMap<>();
        for(int i = 0; i < triangle.size(); ++i){
            for(int j = 0; j < triangle.get(i).size(); ++j){
                sums.put(String.valueOf(i) + j, Integer.MAX_VALUE);
            }
        }

        return recursiveSearch(0, 0, triangle, sums);
    }

    public int recursiveSearch(int i, int j, List<List<Integer>> triangle, Map<String, Integer> sums){
        if(i == triangle.size() || (i < triangle.size() && j == triangle.get(i).size())){
            return Integer.MAX_VALUE;
        }

        if(i == triangle.size() - 1 && j < triangle.get(i).size()){
            sums.put(String.valueOf(i) + j, triangle.get(i).get(j));
            return triangle.get(i).get(j);
        }

        int d = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        if(i + 1 < triangle.size()){

            if(sums.get(String.valueOf(i + 1) + j) == Integer.MAX_VALUE){
                recursiveSearch(i + 1, j, triangle, sums);
            }
            d = sums.get(String.valueOf(i + 1) + j);

            if(j + 1 < triangle.get(i + 1).size()){
                int tmpJ = j + 1;
                if(sums.get(String.valueOf(i + 1) + tmpJ) == Integer.MAX_VALUE){
                    recursiveSearch(i + 1, j + 1, triangle, sums);
                }

                r = sums.get(String.valueOf(i + 1) + tmpJ);
            }
        }


        int sum = triangle.get(i).get(j) + Math.min(d, r);
        sums.put(String.valueOf(i) + j, sum);

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
