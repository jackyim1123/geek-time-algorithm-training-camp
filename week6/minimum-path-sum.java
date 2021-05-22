class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length < 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        // int[][]dp = new int[row][col];
        // dp = grid;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) { // top border
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }  
            }
        }
        return grid[row - 1][col - 1];
    }
}

// Reference: https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/