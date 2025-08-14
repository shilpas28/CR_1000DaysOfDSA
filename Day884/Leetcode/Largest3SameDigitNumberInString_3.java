//Leetcode
//2264. Largest 3-Same-Digit Number in String
//Time complexity: O(n), where n is the length of the input number num. The code iterates through each digit of the number once.
//Space complexity: O(1), as the code uses a constant amount of extra space regardless of the input size.

package Leetcode;

public class Largest3SameDigitNumberInString_3 {

    public static void main(String[] args) {
        String num = "6777133339";
        System.out.println(largestGoodInteger(num));
    }

    public static String largestGoodInteger(String num) {
        int target = -1;
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                int current = Integer.parseInt(num.substring(i, i + 3));
                if (current > target) {
                    target = current;
                }
            }
        }
        if (target != -1) {
            if (target == 0) {
                return target + "00";
            }
            return Integer.toString(target);
        }
        return "";
    }
}
