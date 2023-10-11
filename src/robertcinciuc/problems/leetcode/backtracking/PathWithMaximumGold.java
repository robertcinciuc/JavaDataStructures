package robertcinciuc.problems.leetcode.backtracking;

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == 0){
                    continue;
                }
                int sum = recursiveSearch(grid, i, j);
                if(sum > maxGold){
                    maxGold = sum;
                }
            }
        }

        return maxGold;
    }

    private int recursiveSearch(int[][] grid, int x, int y) {
        if (grid[x][y] == 0) {
            return 0;
        }

        int tmpVal = grid[x][y];
        grid[x][y] = 0;
        int maxGold = 0;

        if (x > 0) {
            int sum1 = recursiveSearch(grid, x - 1, y);
            if (sum1 > maxGold) {
                maxGold = sum1;
            }
        }

        if (y > 0) {
            int sum1 = recursiveSearch(grid, x, y - 1);
            if (sum1 > maxGold) {
                maxGold = sum1;
            }
        }

        if (x < grid.length - 1) {
            int sum1 = recursiveSearch(grid, x + 1, y);
            if (sum1 > maxGold) {
                maxGold = sum1;
            }
        }

        if (y < grid[0].length - 1) {
            int sum1 = recursiveSearch(grid, x, y + 1);
            if (sum1 > maxGold) {
                maxGold = sum1;
            }
        }

        grid[x][y] = tmpVal;

        return maxGold + tmpVal;
    }
}
