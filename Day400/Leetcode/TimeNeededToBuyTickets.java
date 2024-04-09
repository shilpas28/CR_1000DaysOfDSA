//Leetcode
//2073. Time Needed to Buy Tickets - Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1)

public class TimeNeededToBuyTickets {

    public static void main(String[] args) {
        int[] tickets = { 2, 3, 2 };
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;

        if (tickets[k] == 1)
            return k + 1;
        while (tickets[k] > 0) {
            for (int i = 0; i < n; i++) {
                if (tickets[i] == 0)
                    continue;
                tickets[i] = tickets[i] - 1;
                time++;
                if (tickets[k] == 0)
                    break;
            }
        }
        k--;
        return time;
    }
}
