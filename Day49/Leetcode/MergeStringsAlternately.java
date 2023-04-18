//Leetcode
//1768. Merge Strings Alternately
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
            i++;
        }

        if (i < word1.length()) {
            for (int j = i; j < word1.length(); j++)
                result.append(word1.charAt(j));
        }
        if (i < word2.length()) {
            for (int j = i; j < word2.length(); j++)
                result.append(word2.charAt(j));
        }
        return result.toString();

    }
}
