//Leetcode
//338. Counting Bits - Using DP (Recursion)
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class CountingBits_3 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(countBits(n)));
    }

    public static int[] countBits(int n) {
        int res[] = new int[n + 1]; // create one result array,
        // & our array size is n + 1 because we have to cover 0 as well
        for (int i = 0; i <= n; i++) { // run a loop to store all the values we get from a solve function
            res[i] = solve(i);
        }
        return res;
    }

    public static int solve(int n) {
        // base condition
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        if (n % 2 == 0)
            return solve(n / 2); // handling even case
        else
            return 1 + solve(n / 2); // handling odd case
    }
}
