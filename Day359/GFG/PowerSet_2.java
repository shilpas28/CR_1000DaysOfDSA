//GFG
//Power Set - Using Backtracking
//Time complexity: O(2^n)
//Space complexity: O(n), recursion stack.

package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet_2 {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(AllPossibleStrings(s));
    }

    public static List<String> AllPossibleStrings(String s) {
        // Code here
        List<String> ans = new ArrayList<String>();
        String f = "";
        ans = solve(0, s, f, ans);
        Collections.sort(ans);
        return ans;
    }

    static List<String> solve(int i, String s, String f, List<String> res) {
        if (i == s.length()) {
            if (f.length() != 0)
                res.add(f);
            return res;
        }
        // picking
        // f = f + s.charAt(i);
        solve(i + 1, s, f + s.charAt(i), res);
        // poping out while backtracking
        // f.pop_back();
        solve(i + 1, s, f, res);
        return res;
    }
}
