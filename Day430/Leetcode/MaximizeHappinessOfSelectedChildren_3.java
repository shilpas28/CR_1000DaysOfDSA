//Leetcode
//3075. Maximize Happiness of Selected Children - Sort
//Time complexity: O(nlogn) where n is the length of the happiness array.
//Space complexity: O(n) where n is the length of the happiness array.

package Leetcode;

import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren_3 {

    public static void main(String[] args) {
        int[] happiness = { 1, 2, 3 };
        int k = 2;
        System.out.println(maximumHappinessSum(happiness, k));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        int itr = 0, updatedValue = 0;
        long maxHappiness = 0;
        for (int i = n - 1; i >= n - k; i--) {
            updatedValue = happiness[i] - itr;
            if (updatedValue > 0)
                maxHappiness += updatedValue;
            itr++;
        }
        return maxHappiness;
    }
}
