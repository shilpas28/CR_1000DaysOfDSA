//Leetcode
//1791. Find Center of Star Graph
//Time complexity: O(N^2)
//Space complexity: O(N)

public class FindCenterOfStarGraph {

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 2 } };
        System.out.println(findCenter(edges));
    }

    public static int findCenter(int[][] edges) {
        int n = edges.length + 1;

        int[] countFreq = new int[n + 1];
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < 2; j++) {
                countFreq[edges[i][j]]++;
            }
        }

        int center = 0;
        for (int i = 1; i <= n; i++) {
            if (countFreq[i] == n - 1) {
                center = i;
                break;
            }
        }
        return center;
    }
}
