//Leetcode
//1903. Largest Odd Number in String
//Time complexity:  O(n), where n is the length of the input string num.
//Space complexity: O(1) since we are not using any extra space that scales with the input size.

package Leetcode;

public class LargestOddNumberInString {

    public static void main(String[] args) {
        String num = "52";
        System.out.println(largestOddNumber(num));
    }

    public static String largestOddNumber(String num) {
        if ((int) num.charAt(num.length() - 1) % 2 == 1)
            return num;
        int i = num.length() - 1;
        while (i >= 0) {
            int n = num.charAt(i);
            if (n % 2 == 1)
                return num.substring(0, i + 1);
            i--;
        }
        return "";
    }
}
