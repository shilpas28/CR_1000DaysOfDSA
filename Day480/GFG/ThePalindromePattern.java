//GFG
//The Palindrome Pattern
//Time complexity: O(N^2)
//Space complexity: O(1)

public class ThePalindromePattern {

    public static void main(String[] args) {
        int arr[][] = { { 1, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 0 } };
        System.out.println(pattern(arr));
    }

    public static String pattern(int[][] arr) {
        // Code here
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // check if ith row is Palindrome
            if (Row_Palindrome(i, n, arr))
                return i + " R";
        }
        for (int i = 0; i < n; i++) {
            // check if ith row is Palindrome
            if (Column_Palindrome(i, n, arr))
                return i + " C";
        }
        return "-1";
    }

    static boolean Row_Palindrome(int row, int n, int a[][]) {
        int l = 0, r = n - 1;
        while (l < r) {
            if (a[row][l] == a[row][r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean Column_Palindrome(int col, int n, int a[][]) {
        int l = 0, r = n - 1;
        while (l < r) {
            if (a[l][col] == a[r][col]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
