//Leetcode
//2709. Greatest Common Divisor Traversal - Using Union Find
//Time complexity: O(n*sqrt(m))
//Space complexity: O(n+m)

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GreatestCommonDivisorTraversal_3 {

    static class Graph {
        private int n;
        private int[] parent, compSize;

        private int getParent(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = getParent(parent[x]);
        }

        private void unionSet(int x, int y) {
            int parx = getParent(x), pary = getParent(y);
            if (parx != pary) {
                if (compSize[parx] < compSize[pary]) {
                    int t = parx;
                    parx = pary;
                    pary = t;
                }
                parent[pary] = parx;
                compSize[parx] += compSize[pary];
            }
        }

        public Graph(int n) {
            this.n = n;
            parent = new int[n];
            compSize = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                compSize[i] = 1;
            }
        }

        public void addEdge(int x, int y) {
            unionSet(x, y);
        }

        public boolean isConnected() {
            return compSize[getParent(0)] == n;
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
