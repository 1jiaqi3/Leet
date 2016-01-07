//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
//For example,

//Consider the following matrix:

//[
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//Given target = 3, return true.
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int i1=0;
        int j1=0;
        int i2=m-1;
        int j2=n-1;
        int midi=(i1+i2)/2;
        int midj=(j1+j2)/2;
        while(i1<=i2&&j1<=j2){
            if(matrix[midi][midj]==target) return true;
            else if(matrix[midi][midj]>target){
                if(midj-1>=0) j2=midj-1;
                else{
                    i2--;
                    j2=n-1;
                }
            }
            else if(matrix[midi][midj]<target){
                if(midj+1<=n-1) j1=midj+1;
                else{
                    i1++;
                    j1=0;
                }
            }
            midi=(i1+i2)/2;
            midj=(j1+j2)/2;
        }
        return false;
    }
}
