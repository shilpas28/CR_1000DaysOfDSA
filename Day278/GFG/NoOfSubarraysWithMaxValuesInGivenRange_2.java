//GFG
//Number of subarrays with maximum values in given range
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class NoOfSubarraysWithMaxValuesInGivenRange_2 {

    public static void main(String[] args) {
        int[] Arr = { 2, 0, 11, 3, 0 };
        int L = 1, R = 10;
        int n = Arr.length;
        System.out.println(countSubarrays(Arr, n, L, R));
    }

    static long countSubarrays(int a[], int n, int L, int R) {
        return solve(a, n, R) - solve(a, n, L - 1);
    }

    static long solve(int a[], int n, int k) {
        long ans = 0;
        int i = 0, j = 0;
        while (j < n) {
            if (a[j] > k) {
                i = j + 1;
                j++;
            } else {
                ans += j - i + 1;
                j++;
            }
        }
        return ans;
    }
}
