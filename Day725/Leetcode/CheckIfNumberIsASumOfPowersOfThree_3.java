//Leetcode
//1780. Check if Number is a Sum of Powers of Three - Ternary Representation
//Time complexity: O(log3n)
//Space complexity: O(1)

public class CheckIfNumberIsASumOfPowersOfThree_3 {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(checkPowersOfThree(n));
    }

    public static boolean checkPowersOfThree(int n) {
        while (n > 0) {
            // Check if this power should be used twice
            if (n % 3 == 2) {
                return false;
            }
            // Divide n by 3 to move to the next greater power
            n /= 3;
        }
        // The ternary representation of n consists only of 0s and 1s
        return true;
    }
}
