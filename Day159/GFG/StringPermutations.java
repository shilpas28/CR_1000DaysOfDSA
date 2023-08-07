//GFG
//String Permutations
//Time complexity: O(N * N!), N = length of string.
//Space complexity: O(1) 

package GFG;

import java.util.ArrayList;
import java.util.Collections;

public class StringPermutations {

    public static void main(String[] args) {
        String S = "AAA";
        System.out.println(permutation(S));
    }

    public static ArrayList<String> permutation(String S) {
        // Your code here
        ArrayList<String> list = new ArrayList<>();
        solve(S, "", list);
        Collections.sort(list);
        return list;
    }

    static void solve(String str, String ans, ArrayList<String> list) {
        if (str.length() == 0) {
            list.add(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String string = str.substring(0, i) + str.substring(i + 1);
            solve(string, ans + c, list);
        }
    }
}
