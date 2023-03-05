//GFG
//Avoid Explosion - Optimal
//Time complexity:
//Space complexity:
package GFG;

import java.util.ArrayList;

public class AvoidExplosion_2 {
    public static void main(String[] args) {
        int n = 5, m = 2;
        int[][] mix = { { 1, 2 }, { 2, 3 }, { 4, 5 }, { 3, 5 }, { 2, 4 } };
        int[][] danger = { { 1, 3 }, { 4, 2 } };
        System.out.println(avoidExplosion(mix, n, danger, m));
    }

    public static ArrayList<String> avoidExplosion(int mix[][], int n, int danger[][], int m) {

        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = mix[i][0], y = mix[i][1];
            int px = findPar(parent, x), py = findPar(parent, y);

            boolean safe = true;

            for (int[] dd : danger) {
                int u = dd[0], v = dd[1];
                int pu = findPar(parent, u), pv = findPar(parent, v);

                if ((pu == px && py == pv) || (pv == px && pu == py)) {
                    safe = false;
                    break;
                }
            }

            ans.add(safe ? "Yes" : "No");
            if (safe)
                union(px, py, parent, rank);
        }
        return ans;
    }

    public static void union(int x, int y, int[] parent, int[] rank) {
        if (rank[x] > rank[y]) {
            parent[y] = x;
            rank[x]++;
        } else if (rank[y] > rank[x]) {
            parent[x] = y;
            rank[y]++;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }

    public static int findPar(int[] parent, int val) {
        if (parent[val] == val)
            return val;

        return parent[val] = findPar(parent, parent[val]);
    }
}
