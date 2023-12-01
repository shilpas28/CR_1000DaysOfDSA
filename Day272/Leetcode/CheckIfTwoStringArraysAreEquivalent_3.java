//Leetcode
//1662. Check If Two String Arrays are Equivalent
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class CheckIfTwoStringArraysAreEquivalent_3 {

    public static void main(String[] args) {
        String[] word1 = { "ab", "c" };
        String[] word2 = { "a", "bc" };
        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0; // inner pointers or word pointers
        int m = 0, n = 0; // outer pointers or char pointers

        while (i < word1.length && j < word2.length) {
            String curr1 = word1[i], curr2 = word2[j];

            if (curr1.charAt(m) != curr2.charAt(n))
                return false;

            if (m < curr1.length() - 1) {
                m++;
            } else {
                m = 0;
                i++;
            }

            if (n < curr2.length() - 1) {
                n++;
            } else {
                n = 0;
                j++;
            }
        }
        return i == word1.length && j == word2.length;
    }
}
