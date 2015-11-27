//Given a m x n grid filled with non-negative numbers, 
//find a path from top left to bottom right which minimizes the sum of all numbers along its path.
public class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        dp[1][1]=grid[0][0];
        if(m==1&&n==1) return dp[1][1];
        else if(m!=1){
            for(int i=2;i<=m;i++){
                dp[i][1]=grid[i-1][0]+dp[i-1][1];
            }
        }
        if(n!=1){
            for(int i=2;i<=n;i++){
                dp[1][i]=grid[0][i-1]+dp[1][i-1];
            }
        }
        if(m!=1&&n!=1){
            for(int i=2;i<=m;i++){
                for(int j=2;j<=n;j++){
                    dp[i][j]=Math.min(dp[i-1][j]+grid[i-1][j-1],dp[i][j-1]+grid[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
