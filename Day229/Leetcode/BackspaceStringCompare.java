//Leetcode
//844. Backspace String Compare - Naive Approach (Stack)
//Time complexity: O(N + M) - The algorithm processes both input strings in a single pass, character by character. 
//In the worst case, it iterates through both strings, which have lengths of N and M, respectively. Therefore, the time 
//complexity of this algorithm is O(N + M), where N and M are the lengths of the input strings S and T.
//Space complexity: O(N + M) - The space complexity is determined by the space used for the two stacks to store characters. 
//In the worst case, the size of the stacks can be as large as the input strings, so the space complexity is O(N + M). 
//Additionally, there is some constant space used for variables and the string-to-char array conversion, but this is 
//typically negligible compared to the stack space. Therefore, the space complexity is O(N + M), where N and M are the 
//lengths of the input strings S and T.

package Leetcode;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        // Use stacks to simulate the typing process
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        // Process string S
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stackS.push(c); // Push character onto the stack
            } else if (!stackS.isEmpty()) {
                stackS.pop(); // Pop if it's a backspace and the stack is not empty
            }
        }
        // Process string T
        for (char c : t.toCharArray()) {
            if (c != '#') {
                stackT.push(c); // Push character onto the stack
            } else if (!stackT.isEmpty()) {
                stackT.pop(); // Pop if it's a backspace and the stack is not empty
            }
        }
        // Compare the contents of the two stacks
        return stackS.equals(stackT);
    }
}
