/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/
public class Solution {
    public void rotate(int[][] matrix) {
        int layer = matrix.length / 2;
        int start = 0;
        int end = matrix.length - 1;
        for (int i = 0; i < layer; i++) {
            for (int j = start; j < end; j++) {
                int tmp = matrix[start][j];
                matrix[start][j] = matrix[end - j + start][start];
                matrix[end - j + start][start] = matrix[end][end - j + start];
                matrix[end][end - j + start] = matrix[j][end];
                matrix[j][end] = tmp;
            }
            start++;
            end--;
        }
    }
}
