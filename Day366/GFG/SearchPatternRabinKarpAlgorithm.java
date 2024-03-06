//GFG
//Search Pattern (Rabin-Karp Algorithm)
//Time complexity: O(m*(n-m+1)) [Worst case time complexity] where m = length of pattern, n = length of text.
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;

public class SearchPatternRabinKarpAlgorithm {

    public static void main(String[] args) {
        String text = "geeksforgeeks";
        String pattern = "geek";
        System.out.println(search(pattern, text));
    }

    static ArrayList<Integer> search(String pattern, String text) {
        // your code here
        int n = text.length();
        int m = pattern.length();
        ArrayList<Integer> res = new ArrayList<>();

        int j;
        for (int i = 0; i <= n - m; i++) {

            for (j = 0; j < m; ++j) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    break;
                }
            }

            if (j == m) {
                res.add(i+1);
            }
        }
        return res;
    }
}
