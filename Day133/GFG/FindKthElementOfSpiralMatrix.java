//GFG
//Find kth element of spiral matrix
//Time complexity: O(N*M)
//Space complexity: O(1)

package GFG;

public class FindKthElementOfSpiralMatrix {

    public static void main(String[] args) {
        int n = 4, m = 4, k = 10;
        int A[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        System.out.println(findK(A, n, m, k));
    }

    static int findK(int A[][], int n, int m, int k) {
        // Your code here
        int cnt = 0;
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                cnt++;
                if (cnt == k)
                    return A[top][i];
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                {
                    cnt++;
                    if (cnt == k)
                        return A[i][right];
                }
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    cnt++;
                    if (cnt == k)
                        return A[bottom][i];
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    cnt++;
                    if (cnt == k)
                        return A[i][left];
                }
                left++;
            }
        }
        return 0;
    }
}
