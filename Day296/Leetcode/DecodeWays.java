//Leetcode - Not accepted as TLE
//91. Decode Ways - Using Recursion
//Time complexity: O(2^n)
//Space complexity: O(n)

package Leetcode;

public class DecodeWays {

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        return recursiveDecode(s, 0);
    }

    static int recursiveDecode(String s, int index) {
        // Base case: if the index reaches the end of the string
        if (index == s.length()) {
            return 1; // This is a valid decoding
        }
        // Check for leading zero
        if (s.charAt(index) == '0') {
            return 0; // This decoding is invalid
        }
        // Decode single digit
        int ways = recursiveDecode(s, index + 1);
        // Decode two digits if possible
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ways += recursiveDecode(s, index + 2);
        }
        return ways;
    }
}
