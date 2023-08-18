//Leetcode
//1615. Maximal Network Rank
//Time complexity: O(N^2)
//Space complexity: O(2d matrix)

package Leetcode;

public class MaximalNetworkRank_2 {

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
        System.out.println(maximalNetworkRank(n, roads));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        int[][] direct = new int[n][n];
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
            direct[road[0]][road[1]] = 1;
            direct[road[1]][road[0]] = 1;
        }
        int rank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                rank = Math.max(rank, count[i] + count[j] - direct[i][j]);
            }
        }
        return rank;
    }
}
