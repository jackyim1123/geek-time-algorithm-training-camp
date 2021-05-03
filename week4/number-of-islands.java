class Solution {
    private int rowNums;
    private int colNums;

    public int numIslands(char[][] grid) {
        // 1. DFS
        // 2. BFS
        // 3. Union-find
        // thoughs: 1. find 1, islands++, 2. marking adjacency(up, down, left, right) islands(1) to 0.
        int numOfIslands = 0;
        rowNums = grid.length;
        if (rowNums == 0) {
            return 0;
        } 
        colNums = grid[0].length;
        
        for (int i = 0; i < rowNums; i++) {
            for (int j = 0; j < colNums; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || i >= rowNums || j < 0 || j >= colNums || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}