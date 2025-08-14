//Leetcode
//2264. Largest 3-Same-Digit Number in String
//Time complexity: O(n), where n is the length of the input string num.
//Space complexity: O(1) as we are using a constant amount of space for variables.

package Leetcode;

public class Largest3SameDigitNumberInString {

    public static void main(String[] args) {
        String num = "6777133339";
        System.out.println(largestGoodInteger(num));
    }

    public static String largestGoodInteger(String num) {
        int result = -1;
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                result = Math.max(result, num.charAt(i) - '0');
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            builder.append((char) (48 + result));
        }
        return result == -1 ? "" : builder.toString();
    }
}
