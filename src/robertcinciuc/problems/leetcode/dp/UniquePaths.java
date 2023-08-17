package robertcinciuc.problems.leetcode.dp;

import java.util.*;

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] paths = new int[m][n];
        Deque<Integer> xQueue = new ArrayDeque<>();
        Deque<Integer> yQueue = new ArrayDeque<>();
        if(m > 1 && n > 1){
            xQueue.add(1);
            yQueue.add(1);
        }

        for(int i = 0; i < m; ++i){
            paths[i][0] = 1;
        }

        for(int j = 0; j < n; ++j){
            paths[0][j] = 1;
        }

        while(xQueue.size() > 0 && yQueue.size() > 0){
            int x = xQueue.pop();
            int y = yQueue.pop();

            paths[x][y] = paths[x-1][y] + paths[x][y-1];

            if(x < m - 1){
                xQueue.add(x + 1);
                yQueue.add(y);
            }

            if(y < n - 1){
                xQueue.add(x);
                yQueue.add(y + 1);
            }
        }

        return paths[m-1][n-1];
    }

    public static void main(String[] args) {
        var v = new UniquePaths();
        System.out.println(v.uniquePaths(3, 2));
        System.out.println(v.uniquePaths(3, 7));
        System.out.println(v.uniquePaths(1, 1));
    }
}
