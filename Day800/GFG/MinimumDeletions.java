//GFG
//Minimum Deletions
//Time complexity: O(N^2)
//Space complexity: O(N)

public class MinimumDeletions {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(minDeletions(s));
    }

    static int minDeletions(String s) {
        // code here
        int n = s.length();
        int arr[][] = new int[n + 1][n + 1];
        StringBuilder str = new StringBuilder(s);
        str.reverse();

        for (int i = n; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == n || j == n)
                    arr[i][j] = 0;
                else if (s.charAt(i) == str.charAt(j))
                    arr[i][j] = 1 + arr[i + 1][j + 1];
                else
                    arr[i][j] = Math.max(arr[i][j + 1], arr[i + 1][j]);
            }
        }
        return n - arr[0][0];
    }
}
