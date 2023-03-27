//Leetcode - Tabulation method(DP)
//64. Minimum Path Sum
//Time complexity:  O(N*M)
//Space complexity: O(N*M)


public class MinimumPathSum_1 {
    
    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int dp[][]=new int[n][m];
    
        for(int i=0; i<n ; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else{
                    
                    int up = grid[i][j];
                    if(i>0) up += dp[i-1][j];
                    else up += (int)Math.pow(10,9);
                    
                    int left = grid[i][j];
                    if(j>0) left+=dp[i][j-1];
                    else left += (int)Math.pow(10,9);
                    
                    dp[i][j] = Math.min(up,left);
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}
