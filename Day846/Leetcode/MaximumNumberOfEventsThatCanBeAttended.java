//Leetcode
//1353. Maximum Number of Events That Can Be Attended - Optimal Method
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {

    public static void main(String[] args) {
        int[][] events = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        System.out.println(maxEvents(events));
    }

    public static int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int day = 0, index = 0, n = events.length, result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (!pq.isEmpty() || index < n) {
            if (pq.isEmpty()) {
                day = events[index][0];
            }
            while (index < n && events[index][0] <= day) {
                pq.offer(events[index][1]);
                index++;
            }
            pq.poll();
            result++;
            day++;

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }
        return result;
    }
}
