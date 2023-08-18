//Leetcode
//1615. Maximal Network Rank
//Time complexity: O(N^3)
//Space complexity: O(1)

package Leetcode;

public class MaximalNetworkRank {

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
        System.out.println(maximalNetworkRank(n, roads));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        int rank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                for (int[] road : roads) {
                    if (road[0] == i || road[0] == j || road[1] == i || road[1] == j)
                        count++;
                }
                rank = Math.max(rank, count);
            }
        }
        return rank;
    }
}
