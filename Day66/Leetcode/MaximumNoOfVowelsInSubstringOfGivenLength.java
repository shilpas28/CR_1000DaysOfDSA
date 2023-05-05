//Leetcode
//1456. Maximum Number of Vowels in a Substring of Given Length
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MaximumNoOfVowelsInSubstringOfGivenLength {

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    public static int maxVowels(String s, int k) {
        int max_vow = 0, cur_vow = 0;
        for (int i = 0; i < s.length(); i++) {
            cur_vow += isVowel(s.charAt(i));
            if (i >= k)
                cur_vow -= isVowel(s.charAt(i - k));
            max_vow = Math.max(max_vow, cur_vow);
        }
        return max_vow;
    }

    public static int isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return 1;
        return 0;
    }
}
