//Leetcode
//1431. Kids With the Greatest Number of Candies
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithGreatestNumberOfCandies_2 {

    public static void main(String[] args) {
        int[] candies = { 2, 3, 5, 1, 3 };
        int extraCandies = 3;
        kidsWithCandies(candies, extraCandies);
        System.out.println(Arrays.toString(candies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        // Find out max value
        int maxVal = 0;
        for (int candy : candies) {
            maxVal = Math.max(maxVal, candy);
        }
        // Compare with extra candies and max value and return the boolean array
        List<Boolean> res = new ArrayList<Boolean>();
        for (int candy : candies) {
            res.add(candy + extraCandies >= maxVal);
        }
        return res;
    }

}
