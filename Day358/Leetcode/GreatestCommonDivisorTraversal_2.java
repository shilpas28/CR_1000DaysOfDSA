//Leetcode
//2709. Greatest Common Divisor Traversal - Using BFS 
//Time complexity: O(n*sqrt(m))
//Space complexity: O(n+m)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GreatestCommonDivisorTraversal_2 {

    static class Graph {
        private int n;
        private Map<Integer, List<Integer>> edges;
        private boolean[] visited;

        private void traverse(int x) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(x);
            while (!q.isEmpty()) {
                x = q.poll();
                if (!edges.containsKey(x)) {
                    continue;
                }
                for (int y : edges.get(x)) {
                    if (!visited[y]) {
                        q.add(y);
                        visited[y] = true;
                    }
                }
            }
        }

        public Graph(int n) {
            this.n = n;
            edges = new HashMap<>();
            visited = new boolean[n];
        }

        public void addEdge(int x, int y) {
            edges.computeIfAbsent(x, value -> new ArrayList<Integer>()).add(y);
            edges.computeIfAbsent(y, value -> new ArrayList<Integer>()).add(x);
        }

        public boolean isConnected() {
            Arrays.fill(visited, false);
            traverse(0);
            int count = 0;
            for (boolean v : visited) {
                count += v ? 1 : 0;
            }
            return count == n;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 6 };
        int[] nums2 = { 3, 9, 5 };
        System.out.println(canTraverseAllPairs(nums1));
        System.out.println(canTraverseAllPairs(nums2));
    }

    public static boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        Graph g = new Graph(n);
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                return false;
            }
            List<Integer> primeFactors = getPrimeFactors(nums[i]);
            for (int prime : primeFactors) {
                if (seen.containsKey(prime)) {
                    g.addEdge(i, seen.get(prime));
                } else {
                    seen.put(prime, i);
                }
            }
        }
        return g.isConnected();
    }

    static List<Integer> getPrimeFactors(int x) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                primeFactors.add(i);
                while (x % i == 0) {
                    x /= i;
                }
            }
        }
        if (x != 1) {
            primeFactors.add(x);
        }
        return primeFactors;
    }

}
