//GFG - Brute force method - not accepted as TLE
//Equal Left and Right Subarray Sum
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

public class EqualLeftAndRightSubarraySum {

    public static void main(String[] args) {
        int n = 5;
        int A[] = { 1, 3, 5, 2, 2 };
        System.out.println(equalSum(A, n));
    }

    static int equalSum(int[] A, int N) {
        // Write your code here
        for (int i = 0; i < N; i++) {

            int lsum = 0, rsum = 0;
            for (int j = 0; j < i; j++)
                lsum += A[j];

            for (int k = i + 1; k < N; k++)
                rsum += A[k];

            if (lsum == rsum)
                return i + 1;
        }
        return -1;
    }
}
