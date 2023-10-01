//Leetcode
//557. Reverse Words in a String III
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class ReverseWordsInAStringIII_2 {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        char[] s1 = s.toCharArray();
        int i = 0;
        for (int j = 0; j < s1.length; j++) {
            if (s1[j] == ' ') {
                reverse(s1, i, j - 1);
                i = j + 1;
            }
        }
        reverse(s1, i, s1.length - 1);
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
