//GFG
//Better String - Not accepted as TLE
//Time complexity: O(2^N)
//Space complexity: O(N)

package GFG;

import java.util.HashSet;
import java.util.Set;

public class BetterString {

    public static void main(String[] args) {
        String str1 = "gfg", str2 = "ggg";
        System.out.println(betterString(str1, str2));
    }

    public static String betterString(String str1, String str2) {
        // Code here
        int a = getAllSubsequences(str1);
        int b = getAllSubsequences(str2);

        if (b > a)
            return str2;
        return str1;
    }

    static int getAllSubsequences(String str) {
        Set<String> result = new HashSet<>();
        generateSubsequences(str, 0, "", result);
        return result.size();
    }

    static void generateSubsequences(String input, int index, String current, Set<String> result) {
        if (index == input.length()) {
            result.add(current);
            return;
        }
        // take the current character
        generateSubsequences(input, index + 1, current + input.charAt(index), result);
        // not take the current character
        generateSubsequences(input, index + 1, current, result);
    }
}
