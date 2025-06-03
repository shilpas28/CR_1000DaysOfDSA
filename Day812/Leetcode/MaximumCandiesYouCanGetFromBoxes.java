//Leetcode
//1298. Maximum Candies You Can Get from Boxes - DFS
//Time complexity: O(N+K)
//Space complexity: O(N)

public class MaximumCandiesYouCanGetFromBoxes {

    public static void main(String[] args) {
        int[] status = { 1, 0, 1, 0 };
        int[] candies = { 7, 5, 4, 100 };
        int[][] keys = { {}, {}, { 1 }, {} };
        int[][] containedBoxes = { { 1, 2 }, { 3 }, {}, {} };
        int[] initialBoxes = { 0 };
        System.out.println(maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }

    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes,
            int[] initialBoxes) {
        int count = 0; // Total candies collected
        boolean[] vis = new boolean[status.length]; // Track visited boxes
        for (int v : initialBoxes) {
            dfs(v, status, keys, containedBoxes, vis);
        }

        for (int i = 0; i < candies.length; i++) {
            if (vis[i] && status[i] == 1) {
                count += candies[i];
            }
        }
        return count;
    }

    static void dfs(int v, int[] status, int[][] keys, int[][] containedBoxes, boolean[] vis) {

        vis[v] = true; // Mark the current box as visited
        for (int vKey : keys[v]) {
            if (vKey == v)
                continue; // Skip self-key
            status[vKey] = 1; // Unlock the box
        }

        for (int vContained : containedBoxes[v]) {
            if (!vis[vContained]) {
                dfs(vContained, status, keys, containedBoxes, vis);
            }
        }
    }
}
