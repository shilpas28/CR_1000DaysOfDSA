//Leetcode
//1942. The Number of the Smallest Unoccupied Chair - USing 1 min heap
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheNumberOfTheSmallestUnoccupiedChair_2 {

    public static void main(String[] args) {
        int[][] times = { { 1, 4 }, { 2, 3 }, { 4, 6 } };
        int targetFriend = 1;
        System.out.println(smallestChair(times, targetFriend));
    }

    static class Pair {
        int idx, time;

        Pair(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        
        int n = times.length;
        Pair arr[] = new Pair[n];
        Pair dept[] = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(i, times[i][0]);
            dept[i] = new Pair(i, times[i][1]);
        }

        Arrays.sort(arr, (a, b) -> a.time - b.time);
        Arrays.sort(dept, (a, b) -> a.time - b.time);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= 10000; i++)
            pq.add(i);

        int alloted[] = new int[n];
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (arr[i].time < dept[j].time) {
                alloted[arr[i].idx] = pq.poll();
                i++;
            } else if (arr[i].time >= dept[j].time) {
                pq.add(alloted[dept[j].idx]);
                j++;
            }
        }
        return alloted[targetFriend];
    }
}
