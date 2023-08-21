//Leetcode
//459. Repeated Substring Pattern
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                int num_repeats = len / i;
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < num_repeats; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }
}
