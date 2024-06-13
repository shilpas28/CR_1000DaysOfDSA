//Leetcode
//2037. Minimum Number of Moves to Seat Everyone - Priority Queue
//Time complexity: O(nlog(n))
//Space complexity: O(n) (each priority queue will store n elements)

package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberOfMovesToSeatEveryone_2 {

    public static void main(String[] args) {
        int[] seats = { 3, 1, 5 };
        int[] students = { 2, 7, 4 };
        System.out.println(minMovesToSeat(seats, students));
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> student = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < seats.length; i++) {
            pq.add(seats[i]);
            student.add(students[i]);
        }
        while (!pq.isEmpty()) {
            int a = pq.poll();
            int b = student.poll();
            ans += Math.abs(a - b);
        }
        return ans;
    }
}
