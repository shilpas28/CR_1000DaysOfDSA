//Leetcode
//1625. Lexicographically Smallest String After Applying Operations - DFS
//Time complexity:
//Space complexity:

import java.util.HashSet;
import java.util.Set;

public class LexicographicallySmallestStringAfterApplyingOperations_2 {

    public static void main(String[] args) {
        String s = "5525";
        int a = 9, b = 2;
        System.out.println(findLexSmallestString(s, a, b));
    }

    static String smallest;

    public static String findLexSmallestString(String s, int a, int b) {
        smallest = s;
        dfs(s, a, b, new HashSet<>());
        return smallest;
    }

    static void dfs(String s, int a, int b, Set<String> seen) {
        if (seen.add(s)) {
            if (smallest.compareTo(s) > 0) {
                smallest = s;
            }
            char[] ca = s.toCharArray();
            for (int i = 1; i < ca.length; i += 2) {
                ca[i] = (char) ((ca[i] - '0' + a) % 10 + '0');
            }
            dfs(String.valueOf(ca), a, b, seen);
            dfs(s.substring(b) + s.substring(0, b), a, b, seen);
        }
    }
}
