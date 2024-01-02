//GFG
//Largest Sum Subarray of Size at least K
//Time complexity: O(n)
//Space complexity: O(n) 

package GFG;

public class LargestSumSubarrayOfSizeAtleastK {

    public static void main(String[] args) {
        int n = 4;
        long a[] = { -4, -2, 1, -3 };
        int k = 2;
        System.out.println(maxSumWithK(a, n, k));
    }

    public static long maxSumWithK(long a[], long n, long k) {

        long maxSum[] = new long[(int) n];
        int curr = 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            curr += a[i];
            max = Math.max((int) a[i], curr);
            maxSum[i] = max;

            if (curr < 0)
                curr = 0;
        }

        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        long ans = sum;
        for (int i = (int) k; i < n; i++) {
            sum += a[i] - a[i - (int) k];

            ans = Math.max(ans, (int) sum); // handling exaclty k

            ans = Math.max(ans, (int) sum + maxSum[i - (int) k]); // for more than k
        }
        return ans;
    }

}
