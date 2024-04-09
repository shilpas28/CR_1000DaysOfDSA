//Leetcode
//2073. Time Needed to Buy Tickets - Optimized approach: without extra space
//Time complexity: O(N)
//Space complexity: O(1)

public class TimeNeededToBuyTickets_3 {

    public static void main(String[] args) {
        int[] tickets = { 2, 3, 2 };
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[k], tickets[i]);
            } else {
                time += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        return time;
    }
}
