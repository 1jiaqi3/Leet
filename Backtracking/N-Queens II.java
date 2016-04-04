/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        return backtracking(n, 0, board, 0);
    }
    
    public int backtracking(int n, int col, char[][] board, int total) {
        if (col >= n) {
            return total + 1;
        } else {
            for (int i = 0; i < n; i++) {
                if (isSafe(board, i, col)) {
                    board[i][col] = 'Q'; 
                    total = backtracking(n, col + 1, board, total);
                    board[i][col] = 0;
                }
            }
            return total;
        }
    }
    
    public boolean isSafe(char[][] board, int row, int col) {
        int len = board.length;
        for (int i = 0; i < len; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        int j = row;
        int k = col;
        while (j >= 0 && k >= 0) {
            if (board[j--][k--] == 'Q') {
                return false;
            }
        }
        j = row;
        k = col;
        while (j < len && k < len) {
            if (board[j++][k++] == 'Q') {
                return false;
            }
        }
        j = row;
        k = col;
        while (j >= 0 && k < len) {
            if (board[j--][k++] == 'Q') {
                return false;
            }
        } 
        j = row;
        k = col;
        while (j < len && k >= 0) {
            if (board[j++][k--] == 'Q') {
                return false;
            }
        }
        return true;
    }  
}        
