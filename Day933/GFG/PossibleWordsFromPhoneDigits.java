//GFG
//Possible Words From Phone Digits
//Time complexity: O(4^n)
//Space complexity: O(n)

import java.util.ArrayList;

public class PossibleWordsFromPhoneDigits {

    public static void main(String[] args) {
        int arr[] = { 2, 3 };
        System.out.println(possibleWords(arr));
    }

    // correct mapping (note "pqrs" for digit 7)
    static final String[] DIGIT_TO_CHARS = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    public static ArrayList<String> possibleWords(int[] arr) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return res;
        backtrack(arr, 0, new StringBuilder(), res);
        return res;
    }

    static void backtrack(int[] arr, int idx, StringBuilder cur, ArrayList<String> res) {
        if (idx == arr.length) {
            // only add non-empty strings (if all digits were 0/1 we don't want an empty
            // string)
            if (cur.length() > 0)
                res.add(cur.toString());
            return;
        }

        int d = arr[idx];
        // guard against invalid digits
        if (d < 0 || d > 9)
            return;

        String letters = DIGIT_TO_CHARS[d];
        if (letters.isEmpty()) {
            // skip digits like 0 or 1 which have no mapping
            backtrack(arr, idx + 1, cur, res);
            return;
        }

        for (int i = 0; i < letters.length(); i++) {
            cur.append(letters.charAt(i));
            backtrack(arr, idx + 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
