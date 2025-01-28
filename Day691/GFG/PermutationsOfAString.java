//GFG
//Permutations of a String
//Time complexity: O(n! * n)
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PermutationsOfAString {

    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(findPermutation(s));
    }

    public static ArrayList<String> findPermutation(String s) {
        // Code here
        Set<String> ans = new HashSet<>();
        boolean[] visit = new boolean[s.length()];
        makePermutation(s, ans, "", visit);
        return new ArrayList<>(ans);
    }

    static void makePermutation(String s, Set<String> ans, String curr, boolean[] visit) {
        if (curr.length() == s.length()) {
            ans.add(curr);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                makePermutation(s, ans, curr + s.charAt(i), visit);
                visit[i] = false;
            }
        }
    }
}
