//GFG - DOesnt accept this solution as TLE
//Dominant Pairs - Brute Force solution 
//Time complexity: O(N^2)
//Space complexity: O(1)

public class DominantPairs_1 {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = { 10, 2, 2, 1 };
        System.out.println(dominantPairs(n, arr));
    }

    public static int dominantPairs(int n, int[] arr) {
        // code here
        int res = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = n / 2; j < n; j++) {
                if (arr[i] >= arr[j] * 5)
                    res++;
            }
        }
        return res;
    }
}
