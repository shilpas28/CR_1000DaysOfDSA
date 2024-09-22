//GFG
//Longest Prefix Suffix
//Time complexity: O(|str|)
//Space complexity: O(|str|) 

public class LongestPrefixSuffix {

    public static void main(String[] args) {
        String str = "abab";
        System.out.println(lps(str));
    }

    static int lps(String str) {
        // code here
        int i = 1, j = 0, n = str.length();
        int storeLength[] = new int[n];
        while (i < n) {
            if (str.charAt(i) == str.charAt(j))
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
