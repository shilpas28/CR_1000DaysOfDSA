//Leetcode
//1482. Minimum Number of Days to Make m Bouquets - Brute force method - not accepted as TLE 
//Time complexity: O((max(arr[])-min(arr[])+1) * N), where {max(arr[]) -> maximum element of the array, 
//min(arr[]) -> minimum element of the array, N = size of the array}.
//Reason: We are running a loop to check our answers that are in the range of [min(arr[]), max(arr[])]. For every 
//possible answer, we will call the possible() function. Inside the possible() function, we are traversing the entire 
//array, which results in O(N).
//Space complexity: O(1) as we are not using any extra space to solve this problem.

public class MinimumNumberOfDaysToMakeMBouquets {

    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3, k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length; // Size of the array
        if (val > n)
            return -1; // Impossible case.
        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        for (int i = mini; i <= maxi; i++) {
            if (possible(bloomDay, i, m, k))
                return i;
        }
        return -1;
    }

    public static boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length; // Size of the array
        int cnt = 0;
        int noOfB = 0;
        // Count the number of bouquets:
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }
}
