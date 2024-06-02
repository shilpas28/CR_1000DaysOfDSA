//Leetcode
//344. Reverse String
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class ReverseString_2 {

    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        solve(s, i, j);
    }

    static void solve(char[] s, int start, int end) {
        if (start >= end)
            return;
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        solve(s, ++start, --end);
    }
}
