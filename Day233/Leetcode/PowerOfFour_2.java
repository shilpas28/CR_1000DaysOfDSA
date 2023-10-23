//Leetcode
//342. Power of Four - Using Logarithmic
//Time complexity: O(1) 
//Space complexity: O(1) 

package Leetcode;

public class PowerOfFour_2 {

    public static void main(String[] args) {
        int n = 18;
        System.out.println(isPowerOfFour(n));
    }

    public static boolean isPowerOfFour(int n) {
        if (n == 0)
            return false;
        return (Math.log(n) / Math.log(4)) % 1 == 0;
    }
}
