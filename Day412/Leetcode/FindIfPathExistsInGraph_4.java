//Leetcode
//1971. Find if Path Exists in Graph - Simple union-find without any rank consideration
//Time complexity: O(E log V) checking all edges and since there is no rank based compression, so each union is O(log V)
//Space complexity: O(V)

package Leetcode;

public class FindIfPathExistsInGraph_4 {
    
    static class DisjointSetUnion{
        private int[] parent;
        private int N;
        
        public DisjointSetUnion(int n){
            this.N = n;
            this.parent = new int[this.N];
            for(int i = 0; i < this.N; i++){
                this.parent[i] = i;
            }
        }
        
        public boolean areConnected(int u, int v){
            return find(u) == find(v);
        }
        
        public void union(int u, int v){
            if(u != v){
                int a = find(u);
                int b = find(v);
                parent[a] = b;
            }
        }
        
        private int find(int u){
            int x = u;
            while(x != this.parent[x]){
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
        for(int[] edge : edges){
            set.union(edge[0], edge[1]);
        }
        return set.areConnected(source, destination);
    }
}
