//Leetcode
//135. Candy
//Time complexity: O(N)
//Space complexity: O(1) - Using no extra space

package Leetcode;

public class Candy_3 {

    public static void main(String[] args) {
        int[] ratings = { 1, 0, 2 };
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        if (ratings.length <= 1)
            return ratings.length;
        int candies = 0;
        int up = 0, down = 0;
        int prevSlope = 0;

        for (int i = 1; i < ratings.length; i++) {
            // If increasing then 1; if decreasing then -1; if equal then 0.
            int currSlope = (ratings[i] > ratings[i - 1]) ? 1
                    : (ratings[i] < ratings[i - 1] ? -1 : 0);
            // _
            // If mountain is changing. \_ || \/ || /
            if ((prevSlope < 0 && currSlope >= 0) || (prevSlope > 0 && currSlope == 0)) {
                candies = candies + sum(up) + sum(down) + (Math.max(up, down));
                System.out.println(up + " " + down + " " + candies);
                up = 0;
                down = 0;
            }
            // Add in up/down if slope is increasing or decreasing respectively.
            // If it is a plain, add a candy as it is the base case.
            if (currSlope > 0) {
                up++;
            } else if (currSlope < 0) {
                down++;
            } else {
                candies++;
            }

            prevSlope = currSlope;
        }
        System.out.println(up + " " + down + " " + candies);
        candies = candies + sum(up) + sum(down) + (Math.max(up, down) + 1);
        return candies;
    }

    static int sum(int n) {
        return (n * (n + 1)) / 2;
    }
}
