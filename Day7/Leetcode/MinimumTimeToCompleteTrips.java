//Leetcode
//2187. Minimum Time to Complete Trips
//Time complexity: O(NlogN)
//Space complexity: O(1)

public class MinimumTimeToCompleteTrips {

    public static void main(String[] args) {
        int[] time = { 1, 2, 3 };
        int totalTrips = 5;
        System.out.println(minimumTime(time, totalTrips));
    }

    public static long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long min = time[0];
        for (int t : time) {
            min = Math.min(min, t);
        }
        long right = totalTrips * min;

        while (left < right) {
            long mid = (right - left) / 2 + left;
            // How many trip we can do
            long total = totalTripInGivenTime(time, mid);
            // We cannot reach totalTrips, means mid is too small
            if (total < totalTrips) {
                left = mid + 1;
            } else {
                // We can reach totalTrips, but we want right to be as small as possible
                // Therefore, we don't need to + 1
                right = mid;
            }
        }
        return left;
    }

    public static long totalTripInGivenTime(int[] time, long givenTime) {
        long totalTrips = 0l;
        for (int tripTime : time) {
            totalTrips += ((long) givenTime) / tripTime;
        }
        return totalTrips;
    }
}
