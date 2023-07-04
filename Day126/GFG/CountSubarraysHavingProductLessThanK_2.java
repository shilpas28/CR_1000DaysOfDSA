//GFG
//137. Single Number II
//Time complexity: O(N)
//Space complexity: O(1)

public class CountSubarraysHavingProductLessThanK_2 {
    public static void main(String[] args) {
        int n = 4, k = 10;
        long a[] = { 1, 2, 3, 4 };
        System.out.println(countSubArrayProductLessThanK(a, n, k));
    }

    public static int countSubArrayProductLessThanK(long a[], int n, long k) {
        long p = 1;
        int ans = 0, i = 0, j = 0;
        for (i = 0, j = 0; j < n; j++) {
            p = p * a[j];
            while (p >= k && i < j) {
                p /= a[i];
                i++;
            }
            if (p < k)
                ans += (j - i + 1);
        }
        return ans;
    }
}
