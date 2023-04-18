//Leetcode - Better solution than earlier
//1768. Merge Strings Alternately
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MergeStringsAlternately_2 {
    public static void main(String[] args) {
        String word1 = "abcd", word2 = "pq";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int len = word1.length() + word2.length();
        for (int i = 0; i < len; i++) {
            if (i < word1.length())
                result.append(word1.charAt(i));
            if (i < word2.length())
                result.append(word2.charAt(i));
        }
        return result.toString();
    }
}
