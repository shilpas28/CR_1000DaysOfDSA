//Leetcode
//1552. Magnetic Force Between Two Balls - Optimized Binary Search
//Time complexity: O(n log n + n log (max(position) - min(position)))
//Space complexity: O(1)

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls_2 {

    public static void main(String[] args) {
        int[] position = { 1, 2, 3, 4, 7 };
        int m = 3;
        System.out.println(maxDistance(position, m));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1, r = position[position.length - 1] - position[0];
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int lastPosition = position[0], balls = 1;
            for (int i = 1; i < position.length; i++) {
                if (position[i] - lastPosition >= mid) {
                    lastPosition = position[i];
                    balls++;
                }
            }
            if (balls >= m) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
