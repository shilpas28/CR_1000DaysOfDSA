//GFG
//Largest Sum Subarray of Size at least K
//Time complexity: O(n)
//Space complexity: O(n) 

package GFG;

public class LargestSumSubarrayOfSizeAtleastK_2 {

    public static void main(String[] args) {
        int n = 4;
        long a[] = { -4, -2, 1, -3 };
        int k = 2;
        System.out.println(maxSumWithK(a, n, k));
    }

    public static long maxSumWithK(long a[], long n, long k) {
        long ans = Integer.MIN_VALUE, sum1 = 0, sum2 = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            sum1 += a[i];
            if (i - j + 1 == k) {
                ans = Math.max(sum1, ans);
            } else if (i - j + 1 > k) {
                sum2 += a[j++];
                if (sum2 < 0) {
                    sum1 -= sum2;
                    sum2 = 0;
                }
                ans = Math.max(ans, sum1);
            }
        }
        return ans;
    }
}
