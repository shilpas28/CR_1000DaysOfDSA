//Leetcode
//1239. Maximum Length of a Concatenated String with Unique Characters - DFS
//Time complexity: O(2^M), where M is the maximum length of a string in the array. The DFS explores all possible combinations.
//Space complexity: O(2^M), where M is the maximum length of a string. The space is used for the recursive call stack.

package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters_2 {

    public static void main(String[] args) {

        List<String> arr = new ArrayList<String>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        System.out.println(maxLength(arr));
    }

    static int result = 0;
    public static int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0)
            return 0;

        dfs(arr, "", 0);
        return result;
    }

    static void dfs(List<String> arr, String path, int idx) {
        boolean isUniqueChar = isUniqueChars(path);

        if (isUniqueChar) {
            result = Math.max(path.length(), result);
        }
        if (idx == arr.size() || !isUniqueChar) {
            return;
        }
        for (int i = idx; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }
    }

    static boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
