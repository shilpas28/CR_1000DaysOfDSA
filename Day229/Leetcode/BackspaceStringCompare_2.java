//Leetcode
//844. Backspace String Compare - Two-Pointer Approach
//Time complexity: O(N) - The time complexity of this solution is O(N), where N is the length of the longer input string 
//among s and t. The reason for this is that the algorithm processes each character of both strings once, and the while loop 
//runs until both pointers have reached the beginning of their respective strings.
//Space complexity: O(1) - The space complexity of this solution is O(1) because it uses a constant amount of extra space 
//regardless of the input string lengths. The only extra space used is for variables and loop counters, and it doesn't depend 
//on the size of the input strings.

package Leetcode;

public class BackspaceStringCompare_2 {

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        // Call the findActualCharIndex function with the provided parameters
        int ptrS = findActualCharIndex(s, s.length() - 1);
        int ptrT = findActualCharIndex(t, t.length() - 1);

        while (ptrS >= 0 || ptrT >= 0) {
            // Find the actual character indices for both strings
            ptrS = findActualCharIndex(s, ptrS);
            ptrT = findActualCharIndex(t, ptrT);
            // Check if we have reached the beginning of one of the strings
            if (ptrS < 0 && ptrT < 0) {
                return true; // Both strings are equal after backspacing
            }
            // Compare the characters at the current indices
            if (ptrS < 0 || ptrT < 0 || s.charAt(ptrS) != t.charAt(ptrT)) {
                return false; // Characters are not equal, or one string reached its beginning
            }
            // Move to the previous character in both strings
            ptrS--;
            ptrT--;
        }
        // Both strings are equal after backspacing
        return true;
    }

    // Helper function to find the actual character at a given index after
    // considering backspaces
    // It returns the index of the first non-backspace character in the string.
    static int findActualCharIndex(String str, int index) {
        int backspaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                backspaceCount++;
            } else if (backspaceCount > 0) {
                backspaceCount--;
            } else {
                break;
            }
            index--;
        }
        return index;
    }
}
