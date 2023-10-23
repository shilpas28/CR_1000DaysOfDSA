//GFG
//Maximum sum increasing subsequence
//Time complexity: O(N^2)
//Space complexity: O(N)

package GFG;

public class MaximumSumIncreasingSubsequence {

    public static void main(String[] args) {
        int N = 5;
        int arr[] = { 1, 101, 2, 3, 100 };
        System.out.println(maxSumIS(arr, N));
    }

    public static int maxSumIS(int arr[], int n) {
        // code here.
        int i, j, max = 0;
        int msis[] = new int[n];
        // Initialize msis values for all indexes
        for (i = 0; i < n; i++)
            msis[i] = arr[i];
        // Compute maximum sum values in bottom up manner
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] &&
                        msis[i] < msis[j] + arr[i])
                    msis[i] = msis[j] + arr[i];
        // Pick maximum of all msis values
        for (i = 0; i < n; i++)
            if (max < msis[i])
                max = msis[i];

        return max;
    }

}
