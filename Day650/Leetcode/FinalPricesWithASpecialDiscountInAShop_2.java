//Leetcode
//1475. Final Prices With a Special Discount in a Shop - Monotonic Stack
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop_2 {

    public static void main(String[] args) {
        int[] prices = { 8, 4, 6, 2, 3 };
        System.out.println(Arrays.toString(finalPrices(prices)));
    }

    public static int[] finalPrices(int[] prices) {
        // Create a copy of prices array to store discounted prices
        int[] result = prices.clone();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            // Process items that can be discounted by current price
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                // Apply discount to previous item using current price
                result[stack.pop()] -= prices[i];
            }
            // Add current index to stack
            stack.add(i);
        }
        return result;
    }
}
