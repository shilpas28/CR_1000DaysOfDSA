//GFG - using Linear search. Not accepted as TLE
//Partition The Array
//Time complexity: O(N^2)
//Space complexity: O(N)

package GFG;

public class PartitionTheArray {
    public static void main(String[] args) {
        int N = 5;
        int A[] = { 4, 2, 2, 5, 1 };
        System.out.println(minDifference(N, A));
    }

    static long minDifference(int N, int A[]) {
        //code here
        long[] prefixSum = new long[N];
        prefixSum[0] = A[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 1; i < N - 2; i++) {
            long[] maxMinLeft = maxMin(prefixSum, 0, i);
            long[] maxMinRight = maxMin(prefixSum, i + 1, N - 1);

            long value = Math.max(maxMinLeft[1], maxMinRight[1]) - Math.min(maxMinLeft[0], maxMinRight[0]);
            ans = Math.min(ans, value);
        }
        return ans;
    }

    static long[] maxMin(long[] prefixSum, int l, int r) {
        long maxSum = Long.MAX_VALUE, minSum = 0;
        for (int i = l; i < r; i++) {
            long leftSum = prefixSum[i] - ((l - 1) >= 0 ? prefixSum[l - 1] : 0);
            long rightSum = prefixSum[r] - prefixSum[i];
            if (Math.abs(rightSum - leftSum) < maxSum - minSum) {
                maxSum = Math.max(leftSum, rightSum);
                minSum = Math.min(leftSum, rightSum);
            }
        }
        return new long[] { minSum, maxSum };
    }

}
