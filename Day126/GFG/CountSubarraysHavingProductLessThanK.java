//GFG
//137. Single Number II
//Time complexity: O(N^2)
//Space complexity: O(1)

public class CountSubarraysHavingProductLessThanK {

    public static void main(String[] args) {
        int n = 4, k = 10;
        long a[] = { 1, 2, 3, 4 };
        System.out.println(countSubArrayProductLessThanK(a, n, k));
    }

    public static int countSubArrayProductLessThanK(long a[], int n, long k) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            long p = 1;
            for (int j = i; j < n; j++) {
                p = p * a[j];
                if (p < k)
                    res++;
                else
                    break;
            }
        }
        return res;
    }
}
