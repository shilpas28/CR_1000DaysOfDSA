//Leetcode
//1092. Shortest Common Supersequence - Backtracking (Time Limit Exceeded)
//Time complexity: O(2^(n+m)*(n+m))
//Space complexity: O((n+m)^2)

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";
        System.out.println(shortestCommonSupersequence(str1, str2));
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        // Base case: both strings are empty
        if (str1.isEmpty() && str2.isEmpty()) {
            return "";
        }
        // Base case: one string is empty, append the other string
        if (str1.isEmpty()) {
            return str2;
        }
        if (str2.isEmpty()) {
            return str1;
        }
        // If the first characters match, include it in the supersequence
        if (str1.charAt(0) == str2.charAt(0)) {
            return (str1.charAt(0) +
                    shortestCommonSupersequence(
                            str1.substring(1),
                            str2.substring(1)));
        } else {
            // Try both options: picking from str1 or str2, and choose the shorter one
            String pickStr1 = str1.charAt(0) +
                    shortestCommonSupersequence(str1.substring(1), str2);
            String pickStr2 = str2.charAt(0) +
                    shortestCommonSupersequence(str1, str2.substring(1));

            return (pickStr1.length() < pickStr2.length())
                    ? pickStr1
                    : pickStr2;
        }
    }
}
