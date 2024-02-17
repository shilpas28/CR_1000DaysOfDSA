//Leetcode - Not accepted as TLE
//1642. Furthest Building You Can Reach
//Time complexity:
//Space complexity: 

package Leetcode;

public class FurthestBuildingYouCanReach {

    public static void main(String[] args) {
        int[] heights = { 4, 2, 7, 6, 9, 14, 12 };
        int bricks = 5, ladders = 1;
        System.out.println(furthestBuilding(heights, bricks, ladders));
    }

    static int max = 0;

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        if (n == 0)
            return 0;
        solve(heights, bricks, ladders, 0, n, 0);
        return max;
    }

    static void solve(int[] heights, int bricks, int ladders, int idx, int n, int count) {
        if (idx == n - 1) {
            max = Math.max(count, max);
            return;
        }

        if (heights[idx] >= heights[idx + 1]) {
            solve(heights, bricks, ladders, idx + 1, n, count + 1);
        } else {
            int diff = heights[idx + 1] - heights[idx];
            if (bricks >= diff) {
                solve(heights, bricks - diff, ladders, idx + 1, n, count + 1);
                if (ladders > 0) {
                    solve(heights, bricks, ladders - 1, idx + 1, n, count + 1);
                }
            } else if (ladders > 0) {
                solve(heights, bricks, ladders - 1, idx + 1, n, count + 1);
            }
        }
        max = Math.max(count, max);
    }

}
