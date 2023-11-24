//Leetcode
//1561. Maximum Number of Coins You Can Get
//Time complexity: O(NlogN)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {

    public static void main(String[] args) {
        int[] piles = { 2, 4, 1, 2, 7, 8 };
        System.out.println(maxCoins(piles));
    }

    public static int maxCoins(int[] piles) {
        Arrays.sort(piles); // Sort the array
        int n = piles.length; // Number of coins in the array
        int max = 0; // Track my coin value
        // Iterate from n/3 to n-2 inclusive (bob takes the first third in order to get
        // the lowest amount)
        for (int i = n / 3; i < n - 1; i += 2) {
            max += piles[i]; // Add this value to max
        }
        return max; // Return the max value
    }
}
