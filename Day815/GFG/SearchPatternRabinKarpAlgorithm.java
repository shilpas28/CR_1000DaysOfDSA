//GFG
//Search Pattern (Rabin-Karp Algorithm)
//Time complexity: O(m*(n-m+1)) [Worst case time complexity] where m = length of pattern, n = length of text.
//Space complexity: O(1)

import java.util.ArrayList;

public class SearchPatternRabinKarpAlgorithm {

    public static void main(String[] args) {
        String text = "geeksforgeeks", pattern = "geek";
        System.out.println(search(pattern, text));
    }

    static ArrayList<Integer> search(String pat, String txt) {
        // Code here
        ArrayList<Integer> ls = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();

        int[] lps = computeLPSArray(pat); // Preprocess pattern

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                ls.add(i - j + 1); // match found, 1-based index
                j = lps[j - 1]; // continue searching
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // use lps to skip characters
                } else {
                    i++;
                }
            }
        }
        return ls;
    }

    static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // fallback
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
