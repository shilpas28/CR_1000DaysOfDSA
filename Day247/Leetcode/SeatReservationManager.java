//Leetcode
//1845. Seat Reservation Manager
//Time complexity: O(1), O(N) and O(1) - for the three methods 
//Space complexity: 

import java.util.PriorityQueue;

public class SeatReservationManager {

    static class SeatManager {

        static PriorityQueue<Integer> seats;

        public SeatManager(int n) {
            seats = new PriorityQueue<>();
            for (int i = 1; i <= n; i++)
                seats.offer(i);
        }

        public int reserve() {
            return seats.poll();
        }

        public void unreserve(int seatNumber) {
            seats.offer(seatNumber);
        }
    }

    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
        System.out.println(seatManager.reserve()); // All seats are available, so return the lowest numbered seat, which
                                                   // is 1.
        System.out.println(seatManager.reserve()); // The available seats are [2,3,4,5], so return the lowest of them,
                                                   // which is 2.
        seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
        System.out.println(seatManager.reserve()); // The available seats are [2,3,4,5], so return the lowest of them,
                                                   // which is 2.
        System.out.println(seatManager.reserve()); // The available seats are [3,4,5], so return the lowest of them,
                                                   // which is 3.
        System.out.println(seatManager.reserve()); // The available seats are [4,5], so return the lowest of them, which
                                                   // is 4.
        System.out.println(seatManager.reserve()); // The only available seat is seat 5, so return 5.
        seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
    }
}
