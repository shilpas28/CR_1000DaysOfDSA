//Leetcode
//785. Is Graph Bipartite? - Using DFS
//Time complexity: O(V+2E)
//Space complexity: O(V)

package Leetcode;

public class IsGraphBipartite_2 {
    
    public static void main(String[] args) {

        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        //int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];
	    for(int i = 0;i<V;i++) color[i] = -1; 
	    
	    // for connected components
	    for(int i = 0;i<V;i++) {
	        if(color[i] == -1) {
	            if(dfs(i, 0, color, graph) == false) return false; 
	        }
	    }
	    return true; 
    }

    public static boolean dfs(int node, int currentColor, int[] color, int[][] adj) {
        color[node] = currentColor; 
        
        // traverse adjacent nodes
        for(int it : adj[node]) {
            // if uncoloured
            if(color[it] == -1) {
                if(dfs(it, 1 - currentColor, color, adj) == false) return false; 
            }
            // if previously coloured and have the same colour
            else if(color[it] == currentColor) {
                return false; 
            }
        }       
        return true; 
    }

}
