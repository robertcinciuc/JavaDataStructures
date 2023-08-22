package robertcinciuc.problems.leetcode.dp;

import java.util.*;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        Map<String, Integer> sums = new HashMap<>();
        sums.put(String.valueOf(0) + 0, triangle.get(0).get(0));

        int[] res = new int[triangle.get(triangle.size() - 1).size()];
        for(int j = 0; j < triangle.get(triangle.size() - 1).size(); ++j){
            res[j] = Integer.MAX_VALUE;
        }

        recursiveSearch(0, 0, sums, triangle, res);

        int mini = Integer.MAX_VALUE;
        for (int re : res) {
            if (re < mini) {
                mini = re;
            }
        }

        return mini;
    }

    public void recursiveSearch(int i, int j, Map<String, Integer> sums, List<List<Integer>> triangle, int[] res){
        if(i == triangle.size() - 1){
            if(res[j] > sums.get(String.valueOf(i) + j)){
                res[j] = sums.get(String.valueOf(i) + j);
            }
        }

        if(i < triangle.size() && j < triangle.get(i).size()){
            if(i + 1 < triangle.size() && (!sums.containsKey(String.valueOf(i + 1) + j) ||
                    sums.get(String.valueOf(i + 1) + j) > sums.get(String.valueOf(i) + j) + triangle.get(i + 1).get(j))){
                sums.put(String.valueOf(i + 1) + j, sums.get(String.valueOf(i) + j) + triangle.get(i + 1).get(j));
                recursiveSearch(i + 1, j, sums, triangle, res);
            }

            int tmpJ = j + 1;
            if(i + 1 < triangle.size() && j + 1 < triangle.get(i + 1).size() && (!sums.containsKey(String.valueOf(i + 1) + tmpJ) ||
                    sums.get(String.valueOf(i + 1) + tmpJ) > sums.get(String.valueOf(i) + j) + triangle.get(i + 1).get(tmpJ))){
                sums.put(String.valueOf(i + 1) + tmpJ, sums.get(String.valueOf(i) + j) + triangle.get(i + 1).get(tmpJ));
                recursiveSearch(i + 1, tmpJ, sums, triangle, res);
            }
        }
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
    }

}
