//Leetcode
//3075. Maximize Happiness of Selected Children - Reverse Sort
//Time complexity: O(nlogn) where n is the length of the happiness array.
//Space complexity: O(n) where n is the length of the happiness array.

package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximizeHappinessOfSelectedChildren {

    public static void main(String[] args) {
        int[] happiness = { 1, 2, 3 };
        int k = 2;
        System.out.println(maximumHappinessSum(happiness, k));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        List<Integer> happinessList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            happinessList.add(happiness[i]);
        Collections.sort(happinessList, (a, b) -> (b - a));
        long maxHappiness = 0;
        for (int i = 0; i < k; i++)
            maxHappiness += Math.max(happinessList.get(i) - i, 0);
        return maxHappiness;
    }
}
