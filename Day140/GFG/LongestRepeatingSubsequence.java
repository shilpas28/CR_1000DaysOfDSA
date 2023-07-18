//GFG
//Longest Repeating Subsequence
//Time complexity: O(N^2)
//Space complexity: O(N^2)

public class LongestRepeatingSubsequence {

    public static void main(String[] args) {
        String str = "axxzxy";
        System.out.println(longestRepeatingSubsequence(str));
    }

    public static int longestRepeatingSubsequence(String str) {
        // code here
        int n = str.length();
        int nichli[] = new int[n + 1];
        int cur[] = new int[n + 1];
        for (int i = n; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == n || j == n)
                    cur[j] = 0;
                else if (str.charAt(i) == str.charAt(j) && i != j) {
                    cur[j] = 1 + nichli[j + 1];
                } else
                    cur[j] = Math.max(nichli[j], cur[j + 1]);
            }
            nichli = cur.clone();
        }
        return nichli[0];
    }
}
