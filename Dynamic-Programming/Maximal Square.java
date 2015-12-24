/*************
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
**************/
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int max=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=matrix[i][0]-48;
            max=Math.max(max,dp[i][0]);
        } 
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i]-48;
            max=Math.max(max,dp[0][i]);
        } 
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                    int tmp=Math.min(dp[i-1][j],dp[i][j-1]);
                    tmp=Math.min(tmp,dp[i-1][j-1]);
                    dp[i][j]=tmp+1;
                }
                else dp[i][j]=0;
                max=Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}
