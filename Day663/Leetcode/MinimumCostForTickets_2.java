//Leetcode
//983. Minimum Cost For Tickets
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.LinkedList;
import java.util.Queue;

public class MinimumCostForTickets_2 {

    public static void main(String[] args) {
        int[] days = { 1, 4, 6, 7, 8, 20 };
        int[] costs = { 2, 7, 15 };
        System.out.println(mincostTickets(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        Queue<int[]> last7 = new LinkedList<>();
        Queue<int[]> last30 = new LinkedList<>();
        int cost = 0;
        for (int d : days) {
            while (!last7.isEmpty() && last7.peek()[0] + 7 <= d) {
                last7.poll();
            }
            while (!last30.isEmpty() && last30.peek()[0] + 30 <= d) {
                last30.poll();
            }
            last7.offer(new int[] { d, cost + costs[1] });
            last30.offer(new int[] { d, cost + costs[2] });
            cost = Math.min(cost + costs[0], Math.min(last7.peek()[1], last30.peek()[1]));
        }
        return cost;
    }
}
