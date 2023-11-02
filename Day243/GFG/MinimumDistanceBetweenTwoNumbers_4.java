//GFG
//Minimum distance between two numbers
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class MinimumDistanceBetweenTwoNumbers_4 {

    public static void main(String[] args) {
        int N = 4;
        int A[] = { 1, 2, 3, 2 };
        int x = 1, y = 2;
        System.out.println(minDist(A, N, x, y));
    }

    static int minDist(int a[], int n, int x, int y) {
        // code here
        int last_idx = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] == x || a[i] == y) {
                if (last_idx != -1 && a[last_idx] != a[i])
                    ans = Math.min(ans, i - last_idx);

                last_idx = i;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
