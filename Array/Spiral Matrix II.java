/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[0][0];
        int[][] matrix = new int[n][n];
        int startRow = 0;
        int startCol = 0;
        int endRow = n;
        int endCol = n;
        int count = 0;
        while (true) {
            for (int i = startCol; i < endCol; i++) {
                count++;
                matrix[startRow][i] = count;
                if (count == n * n) return matrix;
            }
            startRow++;
            for (int i = startRow; i < endRow; i++) {
                count++;
                matrix[i][endCol - 1] = count;
                if (count == n * n) return matrix;
            }
            endCol--;
            for (int i = endCol - 1; i >= startCol; i--) {
                count++;
                matrix[endRow - 1][i] = count;
                if (count == n * n) return matrix;
            }
            endRow--;
            for (int i = endRow - 1; i >= startRow; i--) {
                count++;
                matrix[i][startCol] = count;
                if (count == n * n) return matrix;
            }
            startCol++;
        }
    }
}
