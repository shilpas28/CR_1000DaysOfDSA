//GFG - Optimal method
//Equal Left and Right Subarray Sum
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class EqualLeftAndRightSubarraySum_3 {

    public static void main(String[] args) {
        int n = 5;
        int A[] = { 1, 3, 5, 2, 2 };
        System.out.println(equalSum(A, n));
    }

    static int equalSum(int[] A, int N) {
        // Write your code here
        if (N == 1)
            return 1;
        int sum = Arrays.stream(A).sum();
        int preSum = 0;

        for (int i = 0; i < N; i++) {
            preSum += A[i];

            if (preSum - A[i] == sum - preSum)
                return i + 1;
        }
        return -1;
    }
}
