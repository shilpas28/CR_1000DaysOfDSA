//Leetcode
//1791. Find Center of Star Graph
//Time complexity: O(1)
//Space complexity: O(1)

public class FindCenterOfStarGraph_3 {

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 2 } };
        System.out.println(findCenter(edges));
    }

    public static int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            return edges[0][0];
        else
            return edges[0][1];
    }
}
