//GFG
//Koko Eating Bananas - Optimal Approach
//Time complexity: O(N * log(max(a[]))), where max(a[]) is the maximum element in the array and N = size of the array.
//We are applying Binary search for the range [1, max(a[])], and for every value of ‘mid’, we are traversing the entire 
//array inside the function named calculateTotalHours().
//Space complexity: O(1) as we are not using any extra space to solve this problem.

public class KokoEatingBananas_2 {

    public static void main(String[] args) {
        int arr[] = { 3, 6, 7, 11 };
        int k = 8;
        System.out.println(kokoEat(arr, k));
    }

    public static int kokoEat(int[] arr, int k) {
        // code here
        int low = 1, high = findMax(arr);
        // apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(arr, mid);
            if (totalH <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
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
