class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }

    public void backTrack(int n, int row, char[][] chessboard) {
        // terminator
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }
        // process current logic
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                // drill down
                backTrack(n, row + 1, chessboard);
                // restore status
                chessboard[row][col] = '.';
            }
        }   
    }

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // check col
        for (int i = 0; i < n; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // check 135 degree(top left)
        for (int i = row - 1, j = col - 1; i >= 0 && j >=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // check 45 degree(top right)
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}

// Reference: https://leetcode-cn.com/problems/n-queens/solution/dai-ma-sui-xiang-lu-51-n-queenshui-su-fa-2k32/