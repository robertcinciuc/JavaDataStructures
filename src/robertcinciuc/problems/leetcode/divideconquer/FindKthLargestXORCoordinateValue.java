package robertcinciuc.problems.leetcode.divideconquer;

import java.util.*;

public class FindKthLargestXORCoordinateValue {

    public int kthLargestValue(int[][] matrix, int k) {

        Map<Integer, Integer> resp = new TreeMap<>(Collections.reverseOrder());

        int[][] tmp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; ++i){
            tmp[i][0] = matrix[i][0];
            for(int j = 1; j < matrix[0].length; ++j){
                tmp[i][j] = tmp[i][j - 1] ^ matrix[i][j];
            }
        }

        for(int j = 0; j < matrix[0].length; ++j){
            for(int i = 1; i < matrix.length; ++i){
                tmp[i][j] = tmp[i - 1][j] ^ tmp[i][j];
            }
        }

        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                if(!resp.containsKey(tmp[i][j])){
                    resp.put(tmp[i][j], 1);
                }else{
                    resp.put(tmp[i][j], resp.get(tmp[i][j]) + 1);
                }

//                resp.merge(tmp[i][j], 1, (key, v) -> resp.get(key) + v);
            }
        }

        int i = 1;
        for(Integer key : resp.keySet()){
            int it = resp.get(key);
            while(it > 0){
                if(i == k){
                    return key;
                }
                it--;
                i++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        var v = new FindKthLargestXORCoordinateValue();
        System.out.println(v.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
        System.out.println(v.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2));
        System.out.println(v.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3));
        System.out.println(v.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 4));
        System.out.println(v.kthLargestValue(new int[][]{{10,9,5},{2,0,4},{1,0,9},{3,4,8}}, 10));
        System.out.println(v.kthLargestValue(new int[][]{{8,10,5,8,5,7,6,0,1,4,10,6,4,3,6,8,7,9,4,2}}, 2));
    }
}
