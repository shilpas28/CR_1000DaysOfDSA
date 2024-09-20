//Leetcode
//214. Shortest Palindrome - KMP method (Knuth-Morris-Pratt)
//Time complexity: O(N)
//Space complexity: O(N)

public class ShortestPalindrome_2 {

    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }

    public static String shortestPalindrome(String s) {
        int count = kmp(new StringBuilder(s).reverse().toString(), s);
        return new StringBuilder(s.substring(count)).reverse().toString() + s;
    }

    static int kmp(String txt, String patt) {
        String newString = patt + '#' + txt;
        int[] pi = new int[newString.length()];
        int i = 1, k = 0;
        while (i < newString.length()) {
            if (newString.charAt(i) == newString.charAt(k)) {
                k++;
                pi[i] = k;
                i++;
            } else {
                if (k > 0) {
                    k = pi[k - 1];
                } else {
                    pi[i] = 0;
                    i++;
                }
            }
        }
        return pi[newString.length() - 1];
    }
}
