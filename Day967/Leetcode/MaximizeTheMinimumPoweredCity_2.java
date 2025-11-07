//Leetcode
//2528. Maximize the Minimum Powered City
//Time complexity: O(n log S)
//Space complexity: O(n)

public class MaximizeTheMinimumPoweredCity_2 {

    public static void main(String[] args) {
        int stations[] = { 1, 2, 4, 5, 0 };
        int r = 1, k = 2;
        System.out.println(maxPower(stations, r, k));
    }

    public static long maxPower(int[] stations, int r, int k) {
        long low = 0, high = 0;
        for (int s : stations)
            high += s;
        high += k;

        long ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (canAchieve(stations, r, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static boolean canAchieve(int[] stations, int r, long k, long target) {
        int n = stations.length;
        long[] add = new long[n];
        long used = 0, windowSum = 0;

        for (int i = 0; i <= r && i < n; i++) {
            windowSum += stations[i];
        }

        for (int i = 0; i < n; i++) {
            if (i - r - 1 >= 0)
                windowSum -= stations[i - r - 1] + add[i - r - 1];
            if (i + r < n && i != 0)
                windowSum += stations[i + r] + add[i + r];

            if (windowSum < target) {
                long need = target - windowSum;
                if (used + need > k)
                    return false;
                used += need;
                add[Math.min(n - 1, i + r)] += need;
                windowSum += need;
            }
        }
        return true;
    }
}
