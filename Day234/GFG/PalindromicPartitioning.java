//GFG - not accepted as TLE
//Palindromic Partitioning - Recursive method 
//Time complexity: Exponential 
//Space complexity:

package GFG;

public class PalindromicPartitioning {

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(palindromicPartition(str));
    }

    static int palindromicPartition(String str) {
        // code here
        int n = str.length();
        return f(0, n, str) - 1;
    }

    static int f(int i, int n, String str) {
        // Base case:
        if (i == n)
            return 0;

        int minCost = Integer.MAX_VALUE;
        // String[i...j]
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, str)) {
                int cost = 1 + f(j + 1, n, str);
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }

    static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
