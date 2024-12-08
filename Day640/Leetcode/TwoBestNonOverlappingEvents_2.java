//Leetcode
//2054. Two Best Non-Overlapping Events - Priority Queue
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.Arrays;
import java.util.PriorityQueue;

public class TwoBestNonOverlappingEvents_2 {

    public static void main(String[] args) {
        int[][] events = { { 1, 3, 2 }, { 4, 5, 2 }, { 2, 4, 3 } };
        System.out.println(maxTwoEvents(events));
    }

    public static int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int maxVal = 0, ans = 0;
        for (int[] e : events) {
            int start = e[0];
            while (!queue.isEmpty()) {
                if (queue.peek()[0] >= start)
                    break;
                int[] eve = queue.remove();
                maxVal = Math.max(maxVal, eve[1]);
            }
            ans = Math.max(ans, e[2] + maxVal);
            queue.add(new int[] { e[1], e[2] });
        }
        return ans;
    }
}
