//Leetcode
//557. Reverse Words in a String III
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class ReverseWordsInAStringIII_3 {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        char[] s1 = s.toCharArray();
        int start = 0, end = 0;
        while (start < s.length()) {
            while (end < s.length() && s1[end] != ' ')
                end++;
            reverse(s1, start, end - 1);
            start = end + 1;
            end = start;
        }
        return new String(s1);
    }

    public static void reverse(char[] s, int l, int r) {
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
