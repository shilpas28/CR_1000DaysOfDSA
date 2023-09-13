//Leetcode
//135. Candy
//Time complexity: O(N)
//Space complexity: O(N) - Using 2 extra arrays

package Leetcode;

import java.util.Arrays;

public class Candy {

    public static void main(String[] args) {
        int[] ratings = { 1, 0, 2 };
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        int candies = 0, n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // Left relative array
        for (int i = 1; i < n; i++) {
            // If current index rating > previous ; give extra candies
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
        }

        // Right relative array
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
        }

        // Merge both the sides
        for (int i = 0; i < n; i++) {
            candies = candies + Math.max(left[i], right[i]);
        }

        return candies;
    }
}
