//GFG
//The Palindrome Pattern
//Time complexity: O(N^2)
//Space complexity: O(1)

public class ThePalindromePattern_2 {

    public static void main(String[] args) {
        int arr[][] = { { 1, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 0 } };
        System.out.println(pattern(arr));
    }

    public static String pattern(int[][] arr) {
        // Code here
        // Checking for rows
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int low = 0, high = n - 1;
            int flag = 0;
            while (low < high) {
                if (arr[i][low] != arr[i][high]) {
                    flag = 1;
                    break;
                }
                low++;
                high--;
            }
            if (flag == 0)
                return new String(i + " " + "R");
        }
        // Checking for columns
        for (int i = 0; i < n; i++) {
            int low = 0, high = n - 1;
            int flag = 0;
            while (low < high) {
                if (arr[low][i] != arr[high][i]) {
                    flag = 1;
                    break;
                }
                low++;
                high--;
            }
            if (flag == 0)
                return new String(i + " " + "C");
        }
        // In case, no palindrome found, return -1
        return "-1";
    }
}
