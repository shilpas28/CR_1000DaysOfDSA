//GFG
//All Palindromic Partitions
//Time complexity: O(2^n * n)
//Space complexity: O(2^n * n)

import java.util.ArrayList;

public class AllPalindromicPartitions {

    public static void main(String[] args) {
        String s = "geeks";
        System.out.println(palinParts(s));
    }

    public static ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int start, String s, ArrayList<String> current, ArrayList<ArrayList<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                backtrack(end + 1, s, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}
