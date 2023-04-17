//Leetcode
//1431. Kids With the Greatest Number of Candies
//Time complexity: O(N*2) - NAIVE METHOD
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] candies = { 2, 3, 5, 1, 3 };
        int extraCandies = 3;
        List<Boolean> res = new ArrayList<>();
        res = kidsWithCandies(candies, extraCandies);
        System.out.println(res);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            boolean check = false;
            for (int j = 0; j < candies.length; j++) {
                if (candies[i] + extraCandies < candies[j]) {
                    check = true;
                    break;
                }
            }
            if (check)
                res.add(false);
            else
                res.add(true);
        }
        return res;
    }

}
