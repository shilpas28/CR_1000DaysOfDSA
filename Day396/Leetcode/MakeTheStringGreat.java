//Leetcode
//1544. Make The String Great
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

public class MakeTheStringGreat {

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            // Now we check if the either the present or the next character is capital
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
                // recursive call for the rest of the string
                return makeGood(s.substring(0, i) + s.substring(i + 2));
            }
        }
        return s;
    }
}
