//GFG
//Alien Dictionary
//Time complexity: O(N * |S| + K) , where |S| denotes maximum length
//Space complexity: O(K)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
        System.out.println(findOrder(dict, N, K));
    }

    public static String findOrder(String[] dict, int N, int K) {
        // Write your code here
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adjList.add(new HashSet<>());
        }
        int[] inDegree = new int[K];

        // Compare adjacent words to build the graph
        for (int i = 0; i < N - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            boolean foundDifference = false;
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int u = word1.charAt(j) - 'a';
                    int v = word2.charAt(j) - 'a';
                    if (!adjList.get(u).contains(v)) {
                        adjList.get(u).add(v);
                        inDegree[v]++;
                    }
                    foundDifference = true;
                    break;
                }
            }
            // If no difference was found and word1 is longer than word2, invalid order
            if (!foundDifference && word1.length() > word2.length()) {
                return ""; // Returning an empty string for invalid input
            }
        }

        // Step 2: Perform topological sort using Kahn's Algorithm (BFS)
        Queue<Integer> zeroInDegreeQueue = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (inDegree[i] == 0) {
                zeroInDegreeQueue.add(i);
            }
        }

        StringBuilder order = new StringBuilder();
        while (!zeroInDegreeQueue.isEmpty()) {
            int u = zeroInDegreeQueue.poll();
            order.append((char) (u + 'a'));
            for (int v : adjList.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    zeroInDegreeQueue.add(v);
                }
            }
        }
        // If the order contains fewer characters than K, there's a cycle
        if (order.length() < K) {
            return ""; // Invalid input with a cycle
        }
        return order.toString();
    }
}
