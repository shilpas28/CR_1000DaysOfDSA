//Leetcode - Not accepted as TLE
//1937. Maximum Number of Points with Cost - Brute Force Approach 
//Time complexity: O((M*N)^2)
//Space complexity: O(N)

package Leetcode;

public class MaximumNumberOfPointsWithCost {

    public static void main(String[] args) {
        int[][] points = { { 1, 2, 3 }, { 1, 5, 1 }, { 3, 1, 1 } };
        System.out.println(maxPoints(points));
    }

    public static long maxPoints(int[][] points) {
        int rows = points.length;
        int cols = points[0].length;
        long[] prev = new long[cols];
        
        for (int i = 0; i < cols; i++) 
            prev[i] = points[0][i];
        
        for (int i = 1; i < rows; i++) {
            long[] curr = new long[cols];
            for (int j = 0; j < cols; j++) {                
                
                int num = points[i][j];
                long ans = 0;
                for (int k = 0; k < cols; k++) {
                    ans = Math.max(ans, num + prev[k] - Math.abs(k - j));
                }
                curr[j] = ans;
            }
            prev = curr;
        }
        
        long maxPoints = 0;
        for (int j = 0; j < cols; j++) 
            maxPoints = Math.max(maxPoints, prev[j]);
        return maxPoints;
    }
}
