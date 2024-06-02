//Leetcode
//344. Reverse String
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class ReverseString_3 {

    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int right = s.length - 1;
        int left = 0;
        while (left < right) {
            // Swap left and right characters;
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            right--;
            left++;
        }
    }
}
