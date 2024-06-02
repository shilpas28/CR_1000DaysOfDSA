//Leetcode
//344. Reverse String
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {

        List<Character> mylist = new ArrayList<>();
        for (int i = s.length - 1; i >= 0; i--) {
            mylist.add(s[i]);
        }
        for (int j = 0; j < s.length; j++) {
            s[j] = mylist.get(j);
        }
    }
}
