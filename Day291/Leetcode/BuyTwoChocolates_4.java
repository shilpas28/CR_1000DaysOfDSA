//Leetcode
//2706. Buy Two Chocolates - 2 Passes
//Time complexity: O(N)
//Space complexity: O(1)

public class BuyTwoChocolates_4 {

    public static void main(String[] args) {
        int[] prices = { 3, 2, 3 };
        int money = 3;
        System.out.println(buyChoco(prices, money));
    }

    public static int buyChoco(int[] prices, int money) {
        // Find the index of the minimum price
        int minIndex = indexMinimum(prices);
        // Remove the minimum price from the array.
        // Save the minimum price in a variable minCost
        int minCost = prices[minIndex];
        prices[minIndex] = Integer.MAX_VALUE;
        // Find the index of the second minimum price
        // which is the minimum of the remaining array
        int secondMinIndex = indexMinimum(prices);
        // Add the second minimum price to minCost
        minCost += prices[secondMinIndex];
        // We can buy chocolates only if we have enough money
        if (minCost <= money) {
            // Return the Amount of Money Left
            return money - minCost;
        }
        // We cannot buy chocolates. Return the initial amount of money
        return money;
    }

    public static int indexMinimum(int[] arr) {
        // Assume the First Element to be the Minimum
        int minIndex = 0;
        // Compare the Assumed Minimum with the Remaining Elements
        // and update assumed minimum if necessary
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        // Return the Index of the Minimum Element
        return minIndex;
    }
}
