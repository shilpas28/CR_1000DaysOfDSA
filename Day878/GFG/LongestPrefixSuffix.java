//GFG
//Longest Prefix Suffix
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class LongestPrefixSuffix {

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(getLPSLength(s));
    }

    static int getLPSLength(String s) {
        // code here
        int i = 1, j = 0, n = s.length();
        int storeLength[] = new int[n];
        while (i < n) {
            if (s.charAt(i) == s.charAt(j))
                storeLength[i++] = ++j;
            else {
                if (j > 0)
                    j = storeLength[j - 1];
                else
                    i++;
            }
        }
        return storeLength[n - 1];
    }
}
