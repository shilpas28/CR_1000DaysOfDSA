//Leetcode
//1642. Furthest Building You Can Reach
//Time complexity: O(nlogn)
//Space complexity: O(n)

package Leetcode;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach_2 {

    public static void main(String[] args) {
        int[] heights = { 4, 2, 7, 6, 9, 14, 12 };
        int bricks = 5, ladders = 1;
        System.out.println(furthestBuilding(heights, bricks, ladders));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = heights.length;
        for (int i = 1; i < n; i++) {
            if (heights[i] > heights[i - 1]) {
                pq.add(heights[i] - heights[i - 1]);
                if (pq.size() > ladders) {
                    bricks -= pq.poll();
                }
            }
            if (bricks < 0)
                return i - 1;
        }
        return n - 1;
    }
}
