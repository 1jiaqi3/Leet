/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, 
where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:
*/
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new LinkedList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        backtracking(n, 0, board, ret);
        return ret;
    }
    
    public void backtracking(int n, int col, char[][] board, List<List<String>> ret) {
        if (col >= n) {
            add(board, ret);
        } else {
            for (int i = 0; i < n; i++) {
                if (isSafe(board, i, col)) {
                    board[i][col] = 'Q'; 
                    backtracking(n, col + 1, board, ret);
                    board[i][col] = '.';
                }
            }
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
    public void add(char[][] board, List<List<String>> ret) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new LinkedList<>();
        int len = board.length;
        for (int i = 0; i < len; i++) {
            list.add(new String(board[i]));
        }
        ret.add(list);
    }
}
