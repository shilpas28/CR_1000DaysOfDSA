//Leetcode
//2028. Find Missing Observations
//Time complexity: O(N+M)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class FindMissingObservations {

    public static void main(String[] args) {
        int[] rolls = { 3, 2, 4, 3 };
        int mean = 4, n = 2;
        System.out.println(Arrays.toString(missingRolls(rolls, mean, n)));
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = n;
        for (int roll : rolls) {
            sum += roll;
        }
        int totalSum = mean * (rolls.length + n);
        int diff = totalSum - sum;

        if (diff > n * 5 || diff < 0) {
            return new int[0];
        }

        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        int i = 0;
        while (diff > 0) {
            int increment = Math.min(diff, 6 - arr[i]);
            arr[i] += increment;
            diff -= increment;
            if (arr[i] == 6) {
                i++;
            }
        }
        return arr;
    }
}
