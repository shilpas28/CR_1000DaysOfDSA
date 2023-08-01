//Leetcode
//77. Combinations
//Time complexity: O(k*nCk), here nCk means the binomial coefficient of picking k elements out of n elements. where nCk = C(n,k) = n!/(n−k)!×k!.
//Space complexity: O(nCk), as stated above the nCk here refers to the binomial coefficient.

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> res = combine(n, k);
        printAdjacencyList(res);
    }

    static List<List<Integer>> ans;

    public static List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        helper(1, n, k, new ArrayList<>());
        return ans;
    }

    public static void helper(int start, int n, int k, List<Integer> sub) {
        if (k == 0) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            sub.add(i);
            helper(i + 1, n, k - 1, sub);
            sub.remove(sub.size() - 1);
        }
    }

    static void printAdjacencyList(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Adjacency list of " + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
