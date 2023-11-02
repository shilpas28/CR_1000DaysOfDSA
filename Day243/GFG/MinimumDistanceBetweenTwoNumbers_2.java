//GFG
//Minimum distance between two numbers - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

public class MinimumDistanceBetweenTwoNumbers_2 {
    public static void main(String[] args) {
        int N = 4;
        int A[] = { 1, 2, 3, 2 };
        int x = 1, y = 2;
        System.out.println(minDist(A, N, x, y));
    }

    static int minDist(int a[], int n, int x, int y) {
        // code here
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((a[i] == x && a[j] == y) || (a[i] == y && a[j] == x))
                    ans = Math.min(ans, Math.abs(i - j));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
