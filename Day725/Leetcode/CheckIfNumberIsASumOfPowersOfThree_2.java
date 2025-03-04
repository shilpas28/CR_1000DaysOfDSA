//Leetcode
//1780. Check if Number is a Sum of Powers of Three - Optimized Iterative Approach
//Time complexity: O(log3n)
//Space complexity: O(1)

public class CheckIfNumberIsASumOfPowersOfThree_2 {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(checkPowersOfThree(n));
    }

    public static boolean checkPowersOfThree(int n) {
        int power = 0;
        // Find the largest power that is smaller or equal to n
        while (Math.pow(3, power) <= n) {
            power++;
        }

        while (n > 0) {
            // Subtract current power from n
            if (n >= Math.pow(3, power)) {
                n -= (int) Math.pow(3, power);
            }
            // We cannot use the same power twice
            if (n >= Math.pow(3, power)) {
                return false;
            }
            // Move to the next lower power
            power--;
        }
        // n has reached 0
        return true;
    }
}
