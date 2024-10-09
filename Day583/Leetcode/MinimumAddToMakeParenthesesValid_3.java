//Leetcode
//921. Minimum Add to Make Parentheses Valid
//Time complexity: O(N)
//Space complexity: O(1) 

public class MinimumAddToMakeParenthesesValid_3 {

    public static void main(String[] args) {
        String str = "(((";
        System.out.println(minAddToMakeValid(str));
    }

    public static int minAddToMakeValid(String s) {
        int count = 0, stk = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                ++stk;
            else if (stk == 0)
                ++count;
            else
                --stk;
        }
        return count + stk;
    }
}
