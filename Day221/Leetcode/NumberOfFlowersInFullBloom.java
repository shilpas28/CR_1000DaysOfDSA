//Leetcode
//2251. Number of Flowers in Full Bloom
//Time complexity: O(NlogN)
//Space complexity: O(N) 

package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfFlowersInFullBloom {

    public static void main(String[] args) {
        int[][] flowers = { { 1, 6 }, { 3, 7 }, { 9, 12 }, { 4, 13 } };
        int[] people = { 2, 3, 7, 11 };
        System.out.println(Arrays.toString(fullBloomFlowers(flowers, people)));
    }

    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        /*
         * 3 events:
         * 0 - Bloom
         * 1 - Person
         * 2 - Die
         */
        // {time position, event type, if person -> index}
        // first sort by time, then by event type
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // add the person events
        for (int i = 0; i < people.length; i++) {
            // for person also add what index they were - {time position, human, index}
            pq.offer(new int[] { people[i], 1, i });
        }
        // add the blossom events
        for (int[] flower : flowers) {
            pq.offer(new int[] { flower[0], 0 });
            pq.offer(new int[] { flower[1], 2 });
        }

        // traverse them all
        int[] ret = new int[people.length];
        int numEvents = pq.size();
        int blooms = 0;
        for (int i = 0; i < numEvents; i++) {
            int[] cur = pq.poll();
            // if bloom, increment blooms
            if (cur[1] == 0) {
                blooms++;
                // if die, decrement blooms
            } else if (cur[1] == 2) {
                blooms--;
                // if person, set their index to # blooms
            } else {
                int personIndex = cur[2];
                ret[personIndex] = blooms;
            }
        }
        return ret;
    }
}
