//GFG
//Count ways to N'th Stair
//Time complexity: O(1)
//Space complexity: O(1)

package GFG;

public class CountWaysToNthStair {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n));
    }

    // Function to count number of ways to reach the nth stair
    // when order does not matter.
    static Long countWays(int n) {
        // your code here
        return (long) n / 2 + 1;
    }
}
