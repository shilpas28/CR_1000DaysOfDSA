//GFG
//Power Set - Using Bit manipulation 
//Time complexity: O(2^n * n) -  O(2^n) for the outer for loop and O(n) for the inner for loop.
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(AllPossibleStrings(s));
    }

    public static List<String> AllPossibleStrings(String s) {
        // Code here
        int n = s.length();
        ArrayList<String> ans = new ArrayList<>();
        for (int num = 0; num < (1 << n); num++) {
            String sub = "";
            for (int i = 0; i < n; i++) {
                // check if the ith bit is set or not
                if ((num & (1 << i)) != 0) {
                    sub += s.charAt(i);
                }
            }
            if (sub.length() > 0) {
                ans.add(sub);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
