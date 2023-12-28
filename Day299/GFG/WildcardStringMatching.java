//GFG
//Wildcard string matching
//Time complexity: O(length of wild string * length of pattern string)
//Space complexity: O(length of wild string * length of pattern string) 

package GFG;

public class WildcardStringMatching {

    public static void main(String[] args) {
        String wild = "ge*ks";
        String pattern = "geeks";
        System.out.println(match(wild, pattern));
    }

    static boolean match(String wild, String pattern) {
        // code here
        int n = wild.length(), m = pattern.length();
        int arr[][] = new int[n + 1][m + 1];
        arr[n][m] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (wild.charAt(i) == pattern.charAt(j)) {
                    if (arr[i + 1][j + 1] == 1)
                        arr[i][j] = 1;
                }
                if (wild.charAt(i) == '*' && (arr[i + 1][j] == 1 || arr[i + 1][j + 1] == 1)) {
                    while (j-- > 0) {
                        arr[i][j] = 1;
                    }
                }
                if (wild.charAt(i) == '?' && arr[i + 1][j + 1] == 1) {
                    arr[i][j] = 1;
                }
            }
        }

        if (arr[0][0] == 1)
            return true;
        return false;
    }
}
