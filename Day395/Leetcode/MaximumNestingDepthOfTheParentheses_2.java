//Leetcode
//1614. Maximum Nesting Depth of the Parentheses
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class MaximumNestingDepthOfTheParentheses_2 {

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        int count = 0;
        int maxNum = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                if (maxNum < count)
                    maxNum = count;
            } else if (c == ')') {
                count--;
            }
        }
        return maxNum;
    }
}
