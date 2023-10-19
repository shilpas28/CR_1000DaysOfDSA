//Leetcode
//844. Backspace String Compare - Reverse and Compare (Two-Pointer)
//Time complexity: O(N) - The time complexity is O(N), where N is the length of the longer input string. In the worst case, 
//you may need to iterate through both input strings once, even though you're using two pointers and skipping characters due 
//to backspaces.
//Space complexity: O(1) - The space complexity is O(1) because the extra space used is constant and doesn't depend on the 
//input string lengths. The solution reverses the input strings in-place and uses only a few integer 
//variables (i, j, backspacesS, and backspacesT) to keep track of the pointers and backspace counts.

package Leetcode;

public class BackspaceStringCompare_4 {

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        // Helper function to reverse a string
        String reversedS = reverseString(s);
        String reversedT = reverseString(t);

        int i = 0; // Pointer for reversedS
        int j = 0; // Pointer for reversedT

        while (i < reversedS.length() || j < reversedT.length()) {
            // Skip backspaces in reversedS
            int backspacesS = 0;
            while (i < reversedS.length() && (reversedS.charAt(i) == '#' || backspacesS > 0)) {
                if (reversedS.charAt(i) == '#') {
                    backspacesS++;
                } else {
                    backspacesS--;
                }
                i++;
            }
            // Skip backspaces in reversedT
            int backspacesT = 0;
            while (j < reversedT.length() && (reversedT.charAt(j) == '#' || backspacesT > 0)) {
                if (reversedT.charAt(j) == '#') {
                    backspacesT++;
                } else {
                    backspacesT--;
                }
                j++;
            }
            // Compare characters
            if (i < reversedS.length() && j < reversedT.length()) {
                if (reversedS.charAt(i) != reversedT.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            } else if (i < reversedS.length() || j < reversedT.length()) {
                // One of the strings reached the end while the other didn't
                return false;
            }
        }
        return true;
    }

    static String reverseString(String s) {
        // Helper function to reverse a string
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return reversed.toString();
    }
}
