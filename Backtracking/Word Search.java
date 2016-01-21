/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (backtracking(board, 0, i, j, word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtracking(char[][] board, int index, int x, int y, String word){
        int m = board.length;
        int n = board[0].length;
        if (index == word.length()){
            return true;
        }
        if (x >= m || x < 0 || y >= n || y < 0){
            return false;
        }
        if (word.charAt(index) == board[x][y]){
            char tmp = board[x][y];
            board[x][y] = '.';
            if (backtracking(board, index + 1, x + 1, y, word) ||
                backtracking(board, index + 1, x - 1, y, word) ||
                backtracking(board, index + 1, x, y + 1, word) ||
                backtracking(board, index + 1, x, y - 1, word)){
                    return true;
            }
            board[x][y] = tmp;
        }
        return false;
    }
}
