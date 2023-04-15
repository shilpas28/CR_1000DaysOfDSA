//Leetcode
//2218. Maximum Value of K Coins From Piles
//Time complexity; O(m*k)
//Space complexity: O(n*k)

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumValueofKCoinsFromPiles {

    public static void main(String[] args) {
        List<List<Integer>> piles = new ArrayList<>();
        List<Integer> innerList = new ArrayList<Integer>(2);
        innerList.add(1);
        innerList.add(100);
        innerList.add(3);
        piles.add(innerList);
        List<Integer> innerList1 = new ArrayList<Integer>(2);
        innerList1.add(7);
        innerList1.add(8);
        innerList1.add(9);
        piles.add(innerList1);
        int k = 2;
        System.out.println(maxValueOfCoins(piles, k));
    }

    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        return func(0, k, piles, dp);
    }

    public static int func(int i, int k, List<List<Integer>> piles, int[][] dp) {
        if (dp[i][k] > 0)
            return dp[i][k];
        if (i == piles.size() || k == 0)
            return 0;
        int res = func(i + 1, k, piles, dp), cur = 0;
        for (int j = 0; j < piles.get(i).size() && j < k; ++j) {
            cur += piles.get(i).get(j);
            res = Math.max(res, func(i + 1, k - j - 1, piles, dp) + cur);
        }
        dp[i][k] = res;
        return res;
    }

}
