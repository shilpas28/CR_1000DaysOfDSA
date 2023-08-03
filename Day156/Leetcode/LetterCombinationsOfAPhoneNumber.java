//Leetcode
//17. Letter Combinations of a Phone Number
//Time complexity: O(N*4^N) 
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    static List<String> ans;
    static String[] dial = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        helper("", 0, digits);
        return ans;
    }

    static void helper(String comb, int index, String digits) {
        if (index == digits.length()) {
            ans.add(comb);
            return;
        }

        String letters = dial[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper(comb + letters.charAt(i), index + 1, digits);
        }
    }
}
