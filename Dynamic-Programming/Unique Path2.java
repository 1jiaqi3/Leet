//Follow up for "Unique Paths":

//Now consider if some obstacles are added to the grids. How many unique paths would there be?

//An obstacle and empty space is marked as 1 and 0 respectively in the grid.

//For example,
//There is one obstacle in the middle of a 3x3 grid as illustrated below.

//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//The total number of unique paths is 2.

//Note: m and n will be at most 100.
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        int i=0;
        while(i<m&&obstacleGrid[i][0]==0){
            dp[i][0]=1;
            i++;
        }
        while(i<m){
            dp[i][0]=0;
            i++;
        }
        int j=0;
        while(j<n&&obstacleGrid[0][j]==0){
            dp[0][j]=1;
            j++;
        }
        while(j<n){
            dp[0][j]=0;
            j++;
        }
        for(int k=1;k<m;k++){
            for(int l=1;l<n;l++){
                if(obstacleGrid[k][l]==0)
                    dp[k][l]=dp[k-1][l]+dp[k][l-1];
                else dp[k][l]=0;
            }
        }
        return dp[m-1][n-1];
    }
}
