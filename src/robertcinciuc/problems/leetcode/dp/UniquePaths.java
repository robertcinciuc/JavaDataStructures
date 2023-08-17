package robertcinciuc.problems.leetcode.dp;

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] paths = new int[m][n];

        for(int i = 0; i < m; ++i){
            paths[i][0] = 1;
        }

        for(int j = 0; j < n; ++j){
            paths[0][j] = 1;
        }

        if(m > 1 && n > 1){
            recursiveSearch(m, n, m - 1, n - 1, paths);
        }

        return paths[m-1][n-1];
    }

    public void recursiveSearch(int m, int n, int x, int y, int[][] paths){

        if(x > 0 && paths[x - 1][y] == 0){
                recursiveSearch(m, n, x - 1, y, paths);
        }

        if(y > 0 && paths[x][y - 1] == 0){
            recursiveSearch(m, n, x, y - 1, paths);
        }

        paths[x][y] = paths[x-1][y] + paths[x][y-1];
    }

    public static void main(String[] args) {
        var v = new UniquePaths();
        System.out.println(v.uniquePaths(3, 2));
        System.out.println(v.uniquePaths(3, 7));
        System.out.println(v.uniquePaths(1, 1));
    }
}
