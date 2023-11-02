//GFG
//Minimum distance between two numbers
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class MinimumDistanceBetweenTwoNumbers_3 {

    public static void main(String[] args) {
        int N = 4;
        int A[] = { 1, 2, 3, 2 };
        int x = 1, y = 2;
        System.out.println(minDist(A, N, x, y));
    }

    static int minDist(int a[], int n, int x, int y) {
        // code here
        int last_x = -1, last_y = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                last_x = i;
                if (last_y != -1)
                    ans = Math.min(ans, Math.abs(last_x - last_y)); // Math.abs(i - last_y
            } else if (a[i] == y) {
                last_y = i;
                if (last_x != -1)
                    ans = Math.min(ans, Math.abs(last_x - last_y)); // Math.abs(last_x - i)
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
