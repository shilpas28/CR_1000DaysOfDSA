//Leetcode
//392. Is Subsequence
//Time complexity: O(m*logn) where m is length of s and n is length of t
//Space complexity: O(1) 

package Leetcode;

public class IsSubsequence {

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }

        if (s.length() == 1 && t.length() == 1) {
            return s.charAt(0) == t.charAt(0);
        }

        int a = 0;
        for (int i = 0; i < t.length(); i++) {
            if (a >= s.length())
                return true;
            if (s.charAt(a) == t.charAt(i)) {
                a += 1;
            }
        }

        if (a == s.length()) {
            return true;
        } else {
            return false;
        }
    }

}
