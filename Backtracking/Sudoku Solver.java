//Write a program to solve a Sudoku puzzle by filling the empty cells.

//Empty cells are indicated by the character '.'.

//You may assume that there will be only one unique solution.
public class Solution {
    public void solveSudoku(char[][] board) {
        realSolver(board, 0, 0);
    }
    public boolean placeable(char[][] board, int row, int col, int number){
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == (char)(number + 48)) {
                return false;
            }
            if (board[row][i] == (char)(number + 48)) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row - row % 3 + i][col - col % 3 + j] == (char)(number + 48)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean realSolver(char[][] board, int row, int col) {
        if (col > 8) {
            col = 0;
            row++;
        }
        if (row > 8) {
            return true;
        }
        if (board[row][col] != '.') {
            return realSolver(board, row, col + 1);
        } else {
            for (int number = 1; number <= 9; number++) {
                if (placeable(board, row, col, number)) {
                    board[row][col] = (char)(number + 48);
                    if (realSolver(board, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
            return false;
        }
    }
}
