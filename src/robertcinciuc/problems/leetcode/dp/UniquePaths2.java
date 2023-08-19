package robertcinciuc.problems.leetcode.dp;

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        boolean foundRock = false;
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1){
                foundRock = true;
            }
            if(!foundRock){
                paths[i][0] = 1;
            }
        }

        foundRock = false;
        for(int j = 0; j < n; j++){
            if(obstacleGrid[0][j] == 1){
                foundRock = true;
            }
            if(!foundRock){
                paths[0][j] = 1;
            }
        }

        if(obstacleGrid[m - 1][n - 1] == 0 && m > 1 && n > 1 && obstacleGrid[0][0] == 0){
            recursiveSearch(obstacleGrid, m - 1, n - 1, paths);
        }

        return paths[m - 1][n - 1];
    }

    public void recursiveSearch(int[][] obstacleGrid, int x, int y, int[][] paths){
        if(x > 0 && obstacleGrid[x - 1][y] == 0 && paths[x - 1][y] == 0){
            recursiveSearch(obstacleGrid, x - 1, y, paths);
        }

        if(y > 0 && obstacleGrid[x][y - 1] == 0 && paths[x][y - 1] == 0){
            recursiveSearch(obstacleGrid, x, y - 1, paths);
        }

        int top = 0;
        if(x > 0){
            top = paths[x - 1][y];
        }

        int left = 0;
        if(y > 0){
            left = paths[x][y - 1];
        }
        paths[x][y] = top + left;
    }

    public static void main(String[] args) {
        var v = new UniquePaths2();
        System.out.println(v.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(v.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
        System.out.println(v.uniquePathsWithObstacles(new int[][]{{0,0},{0,1}}));
        System.out.println(v.uniquePathsWithObstacles(new int[][]{{0}}));
        System.out.println(v.uniquePathsWithObstacles(new int[][]{{0, 0}}));
        System.out.println(v.uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 1}, {0, 0}}));
    }
}
