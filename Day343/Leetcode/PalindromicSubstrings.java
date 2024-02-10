//Leetcode
//647. Palindromic Substrings - Brute force
//Time complexity: O(N^3)
//Space complexity: O(1)

package Leetcode;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }

    static int count1 = 0;

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    count++;
                    if (count1 == 2) {
                        count1 = 0;
                        break;
                    }
                }
            }
        }
        return count;
    }

    static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                count1++;
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
