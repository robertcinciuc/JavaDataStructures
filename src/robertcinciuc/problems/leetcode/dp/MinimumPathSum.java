package robertcinciuc.problems.leetcode.dp;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] paths = new int[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                paths[i][j] = Integer.MAX_VALUE;
            }
        }

        paths[0][0] = grid[0][0];
        recursiveSearch(0, 0, m, n, grid, paths);

        return paths[m - 1][n - 1];
    }

    public void recursiveSearch(int x, int y, int m, int n, int[][] grid, int[][] paths){
        if(x > 0 && paths[x - 1][y] > paths[x][y] + grid[x - 1][y]){
            paths[x - 1][y] = paths[x][y] + grid[x - 1][y];
            recursiveSearch(x - 1, y, m, n, grid, paths);
        }

        if(x < m - 1 && paths[x + 1][y] > paths[x][y] + grid[x + 1][y]){
            paths[x + 1][y] = paths[x][y] + grid[x + 1][y];
            recursiveSearch(x + 1, y, m, n, grid, paths);
        }

        if(y > 0 && paths[x][y - 1] > paths[x][y] + grid[x][y - 1]){
            paths[x][y - 1] = paths[x][y] + grid[x][y - 1];
            recursiveSearch(x, y - 1, m, n, grid, paths);
        }

        if(y < n - 1 && paths[x][y + 1] > paths[x][y] + grid[x][y + 1]){
            paths[x][y + 1] = paths[x][y] + grid[x][y + 1];
            recursiveSearch(x, y + 1, m, n, grid, paths);
        }
    }

    public static void main(String[] args) {
        var v = new MinimumPathSum();
        System.out.println(v.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
