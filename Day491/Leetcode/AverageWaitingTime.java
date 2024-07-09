//Leetcode
//1701. Average Waiting Time
//Time complexity: O(n), where n is the number of customers, as we iterate through the customers list once.
//Space complexity: O(1), as no additional space proportional to the input size is used.

public class AverageWaitingTime {

    public static void main(String[] args) {
        int[][] customers = { { 1, 2 }, { 2, 5 }, { 4, 3 } };
        System.out.println(averageWaitingTime(customers));
    }

    public static double averageWaitingTime(int[][] customers) {
        double total_waiting_time = 0;
        int current_time = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int service = customer[1];
            if (current_time < arrival) {
                current_time = arrival;
            }
            int waiting_time = current_time - arrival + service;
            total_waiting_time += waiting_time;
            current_time += service;
        }

        return total_waiting_time / customers.length;
    }
}
