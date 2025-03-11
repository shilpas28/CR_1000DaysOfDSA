//GFG
//Ways to Reach the n'th Stair - Space Optimization
//Time complexity: O(N), where N is the given number of stairs. This is because we perform a linear number of operations relative 
//to the input size n.
//Space complexity: O(1), As no extra space is being used here.

public class WaysToReachTheNthStair_4 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n));
    }

    static int countWays(int n) {
        // your code here
        /*
         * Initialize two variables to
         * store previous results
         */
        int prev2 = 1;
        int prev = 1;
        // Iterate and update the variables
        for (int i = 2; i <= n; i++) {
            int cur_i = prev2 + prev;
            prev2 = prev;
            prev = cur_i;
        }
        // Return the answer as prev
        return prev;
    }
}
