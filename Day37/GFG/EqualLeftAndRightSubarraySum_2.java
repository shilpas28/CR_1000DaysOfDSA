//GFG - Using prefix and suffix sum arrays(Not so optimal but accepted)
//Equal Left and Right Subarray Sum
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class EqualLeftAndRightSubarraySum_2 {

    public static void main(String[] args) {
        int n = 5;
        int A[] = { 1, 3, 5, 2, 2 };
        System.out.println(equalSum(A, n));
    }

    static int equalSum(int[] A, int N) {
        // Write your code here
        if (N == 1)
            return 1;
        int[] prefixSum = new int[N];
        int[] suffixSum = new int[N];
        prefixSum[0] = A[0];
        suffixSum[N - 1] = A[N - 1];

        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        for (int i = N - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + A[i];
        }

        for (int i = 1; i < N-1; i++) {
            if (prefixSum[i - 1] == suffixSum[i + 1])
                return i + 1;
        }
        return -1;
    }
}
