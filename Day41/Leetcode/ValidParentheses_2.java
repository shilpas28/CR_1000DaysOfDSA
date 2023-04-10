//Leetcode
//20. Valid Parentheses
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class ValidParentheses_2 {
    public static void main(String[] args) {
        String str = "{([])}";
        System.out.println(isBalanced(str));
    }

    public static boolean isBalanced(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack[head++] = c;
                    break;
                case '}':
                    if (head == 0 || stack[--head] != '{')
                        return false;
                    break;
                case ')':
                    if (head == 0 || stack[--head] != '(')
                        return false;
                    break;
                case ']':
                    if (head == 0 || stack[--head] != '[')
                        return false;
                    break;
            }
        }
        return head == 0;
    }
}
