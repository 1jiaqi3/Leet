/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix.length == 0) return ret;
        int m = matrix.length;
        int n =matrix[0].length;
        int startRow = 0;
        int startCol = 0;
        int endRow = m;
        int endCol = n;
        int count = 0;
        while (true) {
            for (int i = startCol; i < endCol; i++) {
                ret.add(matrix[startRow][i]);
                count++;
                if (count == m * n) return ret;
            }
            startRow++;
            for (int i = startRow; i < endRow; i++) {
                ret.add(matrix[i][endCol - 1]);
                count++;
                if (count == m * n) return ret;
            }
            endCol--;
            for (int i = endCol - 1; i >= startCol; i--) {
                ret.add(matrix[endRow - 1][i]);
                count++;
                if (count == m * n) return ret;
            }
            endRow--;
            for (int i = endRow - 1; i >= startRow; i--) {
                ret.add(matrix[i][startCol]);
                count++;
                if (count == m * n) return ret;
            }
            startCol++;
        }
    }
}
