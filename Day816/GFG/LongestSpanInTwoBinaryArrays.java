//GFG
//Longest Span in two Binary Arrays - Brute Force - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class LongestSpanInTwoBinaryArrays {

    public static void main(String[] args) {
        int a1[] = { 0, 1, 0, 0, 0, 0 };
        int a2[] = { 1, 0, 1, 0, 0, 1 };
        System.out.println(longestCommonSum(a1, a2));
    }

    public static int longestCommonSum(int[] a1, int[] a2) {
        // Code here
        int n = a1.length;
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = i; j < n; j++) {
                sum1 += a1[j];
                sum2 += a2[j];
                if (sum1 == sum2) {
                    maxi = Math.max(maxi, j - i + 1);
                }
            }
        }
        return maxi;
    }
}
