//GFG
//Number of subarrays with maximum values in given range
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class NoOfSubarraysWithMaxValuesInGivenRange {

    public static void main(String[] args) {
        int[] Arr = { 2, 0, 11, 3, 0 };
        int L = 1, R = 10;
        int n = Arr.length;
        System.out.println(countSubarrays(Arr, n, L, R));
    }

    static long countSubarrays(int a[], int n, int L, int R) {
        // Complete the function
        long lessThanL = getCountLessThanL(a, n, L);
        long lessThanEqualR = getCountLessThanEqualR(a, n, R);

        return lessThanEqualR - lessThanL;
    }

    static long getCountLessThanL(int[] a, int n, int L) {
        long count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < L)
                count += (i - j + 1);
            else
                j = i + 1;
        }
        return count;
    }

    static long getCountLessThanEqualR(int[] a, int n, int R) {
        long count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= R)
                count += (i - j + 1);
            else
                j = i + 1;
        }
        return count;
    }
}
