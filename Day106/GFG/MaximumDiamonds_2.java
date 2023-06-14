//GFG - Not accepted as TLE
//Maximum Diamonds
//Time complexity: O(K*N)
//Space complexity: O(1)

package GFG;

public class MaximumDiamonds_2 {
    public static void main(String[] args) {
        int N = 5, K = 3;
        int A[] = { 2, 1, 7, 4, 2 };
        System.out.println(maxDiamonds(A, N, K));
    }

    static long maxDiamonds(int[] A, int N, int K) {
        // code here
        long ans = 0;
        for (int i = 0; i < K; i++) {
            int max = A[0];
            int ind = 0;
            for (int j = 1; j < N; j++)
                if (max < A[j]) {
                    max = A[j];
                    ind = j;
                }
            ans += max;
            A[ind] /= 2;
        }
        return ans;
    }
}
