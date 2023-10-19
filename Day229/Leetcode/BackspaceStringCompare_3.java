//Leetcode
//844. Backspace String Compare - Optimized Two-Pointer Approach
//Time complexity: O(M + N) - Here, M is the length of string s, and N is the length of string t. The code uses two pointers, 
//one for each string (i for s and j for t), and it iterates through both strings once. During the iteration, it handles 
//backspaces by skipping characters, but each character in both strings is visited at most once. Therefore, the time 
//complexity is O(M + N).
//Space complexity: O(1) - The code uses a constant amount of extra space to store integer 
//variables (i, j, backspaceCountS, and backspaceCountT) and a few integer constants. It doesn't use any additional data 
//structures like arrays or lists. As a result, the space complexity is O(1), meaning it's constant and not dependent on the 
//input size.

package Leetcode;

public class BackspaceStringCompare_3 {

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int backspaceCountS = 0;
        int backspaceCountT = 0;

        while (i >= 0 || j >= 0) {
            // Find the position of the next valid character in s after considering
            // backspaces
            while (i >= 0 && (s.charAt(i) == '#' || backspaceCountS > 0)) {
                if (s.charAt(i) == '#') {
                    backspaceCountS++;
                } else {
                    backspaceCountS--;
                }
                i--;
            }
            // Find the position of the next valid character in t after considering
            // backspaces
            while (j >= 0 && (t.charAt(j) == '#' || backspaceCountT > 0)) {
                if (t.charAt(j) == '#') {
                    backspaceCountT++;
                } else {
                    backspaceCountT--;
                }
                j--;
            }
            if (i < 0 && j < 0) {
                // Both strings have no more valid characters, they match.
                return true;
            }
            if (i < 0 || j < 0 || s.charAt(i) != t.charAt(j)) {
                // If the valid characters at the current positions don't match, the strings are
                // not equal.
                return false;
            }
            i--;
            j--;
        }
        // If both strings are empty or only contain backspaces, they are considered
        // equal.
        return true;
    }
}
