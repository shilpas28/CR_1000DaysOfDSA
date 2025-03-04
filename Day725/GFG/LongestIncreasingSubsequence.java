//GFG
//Longest Increasing Subsequence
//Time complexity: O(N^2)
//Space complexity: O(N) 

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int arr[] = { 5, 8, 3, 7, 9, 1 };
        System.out.println(lis(arr));
    }

    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        int lis[] = new int[n];
        int i, j, max = 0;

        /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++)
            lis[i] = 1;

        /*
         * Compute optimized LIS values in
         * bottom up manner
         */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }
}
