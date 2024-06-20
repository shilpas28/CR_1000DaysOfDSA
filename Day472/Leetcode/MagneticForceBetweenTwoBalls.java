//Leetcode
//1552. Magnetic Force Between Two Balls - Binary Search
//Time complexity: O(nlogn)
//Space complexity: O(1)

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    public static void main(String[] args) {
        int[] position = { 1, 2, 3, 4, 7 };
        int m = 3;
        System.out.println(maxDistance(position, m));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1;
        int hi = (position[position.length - 1] - position[0]) / (m - 1);
        int ans = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canWePlace(position, mid, m)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    static boolean canWePlace(int[] arr, int dist, int cows) {
        int cntCows = 1;
        int last = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - last >= dist) {
                cntCows++;
                last = arr[i];
            }
            if (cntCows >= cows) {
                return true;
            }
        }
        return false;
    }
}
