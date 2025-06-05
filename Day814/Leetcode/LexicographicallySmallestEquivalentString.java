//Leetcode
//1061. Lexicographically Smallest Equivalent String
//Time complexity: O(N+(M*26))
//Space complexity: O(26+N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexicographicallySmallestEquivalentString {

    public static void main(String[] args) {
        String s1 = "parker", s2 = "morris", baseStr = "parser";
        System.out.println(smallestEquivalentString(s1, s2, baseStr));
    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, List<Character>> adj = new HashMap<>();
        int n = s1.length();

        // Build the adjacency list
        for (int i = 0; i < n; i++) {
            char u = s1.charAt(i);
            char v = s2.charAt(i);

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        StringBuilder result = new StringBuilder();

        for (char ch : baseStr.toCharArray()) {
            boolean[] visited = new boolean[26];
            char minChar = dfs(adj, ch, visited);
            result.append(minChar);
        }

        return result.toString();
    }

    static char dfs(Map<Character, List<Character>> adj, char ch, boolean[] visited) {
        visited[ch - 'a'] = true;
        char minChar = ch;

        for (char neighbor : adj.getOrDefault(ch, new ArrayList<>())) {
            if (!visited[neighbor - 'a']) {
                char candidate = dfs(adj, neighbor, visited);
                if (candidate < minChar) {
                    minChar = candidate;
                }
            }
        }

        return minChar;
    }
}
