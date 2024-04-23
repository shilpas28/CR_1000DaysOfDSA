//Leetcode
//310. Minimum Height Trees - Tree DP
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class MinimumHeightTrees_2 {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
        MinimumHeightTrees obj = new MinimumHeightTrees();
        System.out.println(obj.findMinHeightTrees(n, edges));
    }

    int n;
    List<Integer>[] e;
    int[] height1;
    int[] height2;
    int[] dp;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 0)
            return new ArrayList<>();
        if (n == 1)
            return Arrays.asList(0);

        this.n = n;
        e = new List[n];
        for (int i = 0; i < n; i++)
            e[i] = new ArrayList<>();
        for (int[] pair : edges) {
            int u = pair[0];
            int v = pair[1];
            e[u].add(v);
            e[v].add(u);
        }

        height1 = new int[n];
        height2 = new int[n];
        dp = new int[n];

        dfs(0, -1);
        dfs(0, -1, 0);

        int min = dp[0];
        for (int i : dp)
            if (i < min)
                min = i;

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (dp[i] == min)
                ans.add(i);
        return ans;
    }

    public void dfs(int u, int parent) {
        height1[u] = height2[u] = -Integer.MIN_VALUE / 10;
        for (int v : e[u])
            if (v != parent) {
                dfs(v, u);
                int tmp = height1[v] + 1;
                if (tmp > height1[u]) {
                    height2[u] = height1[u];
                    height1[u] = tmp;
                } else if (tmp > height2[u]) {
                    height2[u] = tmp;
                }
            }
        height1[u] = Math.max(height1[u], 0); // in case u is a leaf.
    }

    public void dfs(int u, int parent, int acc) {
        dp[u] = Math.max(height1[u], acc);
        for (int v : e[u])
            if (v != parent) {
                int newAcc = Math.max(acc + 1, (height1[v] + 1 == height1[u] ? height2[u] : height1[u]) + 1);
                dfs(v, u, newAcc);
            }
    }
}
