//GFG - also not accepted as TLE
//Number of distinct subsequences - using Recursion(Backtracking)
//Time complexity:  O(2^n)
//Space complexity: O(n), recursion stack.

import java.util.HashSet;

public class NumberOfDistinctSubsequences_2 {
    
    public static void main(String[] args) {
        String s = "gfg";
        System.out.println(distinctSubsequences(s));
    }

    static int distinctSubsequences(String S) {
        // code here
        String f = "";
        HashSet<String> ans = new HashSet<>();
        solve(0, S, f, ans);
        return ans.size();
    }

    static void solve(int i, String s, String f, HashSet<String> ans) {

        ans.add(s);
        if (i == s.length()) {
            ans.add(f);
            return;
        }
        //picking 
        //f = f + s.charAt(i);
        solve(i + 1, s,  f+s.charAt(i), ans);
        //poping out while backtracking
        //f.pop_back();
        solve(i + 1, s,  f, ans);
    }
}
