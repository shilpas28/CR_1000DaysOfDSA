//GFG
//Search Pattern (KMP-Algorithm)
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;

public class SearchPatternKMPAlgorithm {

    public static void main(String[] args) {
        String txt = "abcab", pat = "ab";
        System.out.println(search(pat, txt));
    }

    static ArrayList<Integer> search(String pat, String txt) {
        // your code here
        int tn = txt.length(), pn = pat.length();
        int lps[] = new int[pn];
        fill(pat, lps, pn);

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;

        while (j < tn) {
            if (pat.charAt(i) == txt.charAt(j)) {
                i++;
                j++;
            } else {
                if (i == 0)
                    j++;
                else
                    i = lps[i - 1];
            }

            if (i == pn) {
                ans.add(j - pn);
                i = lps[i - 1];
            }
        }
        return ans;
    }

    static void fill(String s, int a[], int n) {
        int i = 0, j = 1;
        while (j < n) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                a[j] = i;
                j++;
            } else {
                if (i == 0)
                    j++;
                else
                    i = a[i - 1];
            }
        }
    }
}
