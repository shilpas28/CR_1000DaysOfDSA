//Leetcode
//2706. Buy Two Chocolates - Greedy Approach
//Time complexity: O(NlogN)
//Space complexity: O(N) or O(NlogN)

import java.util.Arrays;

public class BuyTwoChocolates_2 {

    public static void main(String[] args) {
        int[] prices = { 3, 2, 3 };
        int money = 3;
        System.out.println(buyChoco(prices, money));
    }

    public static int buyChoco(int[] prices, int money) {
        // Sort the Array in Increasing Order
        Arrays.sort(prices);
        // Minimum Cost
        int minCost = prices[0] + prices[1];
        // We can buy chocolates only if we have enough money
        if (minCost <= money) {
            // Return the Amount of Money Left
            return money - minCost;
        } else {
            // We cannot buy chocolates. Return the initial amount of money
            return money;
        }
    }
}
