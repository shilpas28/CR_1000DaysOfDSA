//Leetcode
//Add Digits - using Recursion
//Time complexity: O(no:of digits)
//Space complexity: O(1)

package Leetcode;

public class AddDigits_2 {
    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }

    public static int addDigits(int num) {
        if (num == 0)
            return 0;
        if (num % 9 == 0)
            return 9;
        return num % 9;
    }
}
