//GFG
//Min Add to Make Parentheses Valid
//Time complexity: O(N)
//Space complexity: O(1)

public class MinAddToMakeParenthesesValid_2 {

    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(minParentheses(s));
    }

    public static int minParentheses(String s) {
        // code here
        int c1 = 0, c2 = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            String j = String.valueOf(s.charAt(i));
            if (j.equals("(")) {
                c1++;
            } else {
                if (c1 > c2) {
                    c1--;
                } else {
                    r++;
                }
            }
        }
        r += c1;
        return r;
    }
}
