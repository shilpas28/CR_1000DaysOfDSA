//GFG
//Equalize the Towers
//Time complexity: O(nlogn)
//Space complexity: O(1)

import java.util.Arrays;

public class EqualizeTheTowers {

    public static void main(String[] args) {
        int heights[] = { 1, 2, 3 };
        int cost[] = { 10, 100, 1000 };
        System.out.println(minCost(heights, cost));
    }

    public static int minCost(int[] heights, int[] cost) {
        // code here
        int low = Arrays.stream(heights).min().getAsInt();
        int high = Arrays.stream(heights).max().getAsInt();
        long ans = Long.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            long cost1 = getCost(heights, cost, mid);
            long cost2 = getCost(heights, cost, mid + 1);
            ans = Math.min(cost1, cost2);

            if (cost1 < cost2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    static long getCost(int[] heights, int[] cost, int target) {
        long total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += (long) Math.abs(heights[i] - target) * cost[i];
        }
        return total;
    }
}
