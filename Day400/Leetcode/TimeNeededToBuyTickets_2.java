//Leetcode
//2073. Time Needed to Buy Tickets - Queue approach : taking extra space
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets_2 {

    public static void main(String[] args) {
        int[] tickets = { 2, 3, 2 };
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) {
            q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            ++count;
            int front = q.poll();
            if (tickets[front] >= 1) {
                tickets[front] -= 1;
            }
            if (k == front && tickets[front] == 0) {
                break;
            }
            if (k != front && tickets[front] == 0) {
                continue;
            }
            q.add(front);
        }
        return count;
    }
}
