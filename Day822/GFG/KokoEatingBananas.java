//GFG
//Koko Eating Bananas - Brute Force - Not accepted as TLE
//Time complexity: O(max(a[]) * N), where max(a[]) is the maximum element in the array and N = size of the array.
//We are running nested loops. The outer loop runs for max(a[]) times in the worst case and the inner loop runs for N times.
//Space complexity: O(1) as we are not using any extra space to solve this problem.

public class KokoEatingBananas {

    public static void main(String[] args) {
        int arr[] = { 3, 6, 7, 11 };
        int k = 8;
        System.out.println(kokoEat(arr, k));
    }

    public static int kokoEat(int[] arr, int k) {
        // code here
        // Find the maximum number:
        int maxi = findMax(arr);
        // Find the minimum value of k:
        for (int i = 1; i <= maxi; i++) {
            int reqTime = calculateTotalHours(arr, i);
            if (reqTime <= k) {
                return i;
            }
        }
        // dummy return statement
        return maxi;
    }

    static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        int n = v.length;
        // find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        // find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) (v[i]) / (double) (hourly));
        }
        return totalH;
    }
}
