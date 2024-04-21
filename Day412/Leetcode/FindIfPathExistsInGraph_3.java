//Leetcode
//1971. Find if Path Exists in Graph - Disjoint Set Union by Rank
//Time complexity: O(E alpha(V)) checking all edges and since there is rank based compression, so each union is O(alpha(V))
//Space complexity: O(V) 

package Leetcode;

public class FindIfPathExistsInGraph_3 {

    static class DisjointSetUnion {
        private int[] parent;
        private int[] rank;
        private int N;

        public DisjointSetUnion(int n) {
            this.N = n;
            this.parent = new int[this.N];
            this.rank = new int[this.N];
            for (int i = 0; i < this.N; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public boolean areConnected(int u, int v) {
            return find(u) == find(v);
        }

        public void union(int u, int v) {
            if (u != v) {
                int a = find(u);
                int b = find(v);
                if (a != b) {
                    if (rank[a] > rank[b]) {
                        parent[b] = a;
                        rank[a] += rank[b];
                    } else {
                        parent[a] = b;
                        rank[b] += rank[a];
                    }
                }
            }
        }

        private int find(int u) {
            int x = u;
            while (x != this.parent[x]) {
                x = this.parent[x];
            }

            this.parent[u] = x;
            return x;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        int source = 0, destination = 2;
        System.out.println(validPath(n, edges, source, destination));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSetUnion set = new DisjointSetUnion(n);
        for (int[] edge : edges) {
            set.union(edge[0], edge[1]);
        }
        return set.areConnected(source, destination);
    }
}
