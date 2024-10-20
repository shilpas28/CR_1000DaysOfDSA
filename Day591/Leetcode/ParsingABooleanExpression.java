//Leetcode
//1106. Parsing A Boolean Expression - Recursive solution
//Time complexity: O(N)
//Space complexity: O(N) 

public class ParsingABooleanExpression {

    public static void main(String[] args) {
        String expression = "&(|(f))";
        System.out.println(parseBoolExpr(expression));
    }

    public static boolean parseBoolExpr(String expression) {
        return parse(expression, 0, expression.length());
    }

    static boolean parse(String s, int lo, int hi) {
        char c = s.charAt(lo);
        if (hi - lo == 1)
            return c == 't'; // base case.
        boolean ans = c == '&'; // only when c is &, set ans to true; otherwise false.
        for (int i = lo + 2, start = i, level = 0; i < hi; ++i) {
            char d = s.charAt(i);
            if (level == 0 && (d == ',' || d == ')')) { // locate a valid sub-expression.
                boolean cur = parse(s, start, i); // recurse to sub-problem.
                start = i + 1; // next sub-expression start index.
                if (c == '&')
                    ans &= cur;
                else if (c == '|')
                    ans |= cur;
                else
                    ans = !cur; // c == '!'.
            }
            if (d == '(')
                ++level;
            if (d == ')')
                --level;
        }
        return ans;
    }
}
