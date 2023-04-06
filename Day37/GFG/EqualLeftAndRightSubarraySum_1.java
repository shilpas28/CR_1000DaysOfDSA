//GFG - Optimal method
//Equal Left and Right Subarray Sum
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class EqualLeftAndRightSubarraySum_1 {

    public static void main(String[] args) {
        int n = 5;
        int A[] = { 1, 3, 5, 2, 2 };
        System.out.println(equalSum(A, n));
    }

    static int equalSum(int[] A, int N) {
        // Write your code here
        int sum = 0;
        for (int i = 0; i < N; i++) //sum of all elements
            sum += A[i];
        int lsum = 0;
        for (int i = 0; i < N; i++) {
            sum -= A[i];          //deduct value of array element from sum and keep comparing with lsum
            if (sum == lsum)   
                return i + 1;

            else
                lsum += A[i];   //compute lsum
        }
        return -1;
    }
}
