//Leetcode
//1662. Check If Two String Arrays are Equivalent
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class CheckIfTwoStringArraysAreEquivalent {

    public static void main(String[] args) {
        String[] word1 = { "ab", "c" };
        String[] word2 = { "a", "bc" };
        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (String val : word1) {
            str1.append(val);
        }
        for (String val : word2) {
            str2.append(val);
        }
        return str1.toString().equals(str2.toString());
    }
}
