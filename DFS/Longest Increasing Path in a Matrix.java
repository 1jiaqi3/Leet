/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. 
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int longestPath = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longestPath = Math.max(longestPath, longest(matrix, Integer.MIN_VALUE, i, j, cache));
            }
        }
        return longestPath;
    }
    public int longest(int[][] matrix, int last, int i, int j, int[][] cache) {
        boolean invalid = i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length;
        if (!invalid && last < matrix[i][j] && cache[i][j] != 0) {
            return cache[i][j];
        } else {
            if (invalid || matrix[i][j] <= last) {
                return 0;
            } 
            int temp = matrix[i][j];
            int left = longest(matrix, temp, i - 1, j, cache);
            int right = longest(matrix, temp, i + 1, j, cache);
            int up = longest(matrix, temp, i, j + 1, cache);
            int down = longest(matrix, temp, i, j - 1, cache);
            int ret = 1 + Math.max(Math.max(Math.max(left, right), up), down);
            cache[i][j] = ret;
            return ret;
        }
    }
}
