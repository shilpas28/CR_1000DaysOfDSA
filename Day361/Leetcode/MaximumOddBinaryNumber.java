//Leetcode
//2864. Maximum Odd Binary Number
//Time complexity: O(nlogn)
//Space complexity: O(1) 

package Leetcode;

import java.util.Arrays;

public class MaximumOddBinaryNumber {

    public static void main(String[] args) {
        String s = "0101";
        System.out.println(maximumOddBinaryNumber(s));
    }

    public static String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        // Reverse the char array.
        for (int i = 0; i < chars.length / 2; i++) {
            char j = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = j;
        }
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '1') {
                char temp = chars[i];
                chars[i] = chars[chars.length - 1];
                chars[chars.length - 1] = temp;
                break;
            }
        }
        return new String(chars);
    }
}
