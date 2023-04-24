//Leetcode
//1046. Last Stone Weight
//Time complexity: O(NlogN)
//Space complexity: O(N)

package Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int i = 0; i < stones.length; i++)
            minHeap.add(stones[i]);
        while (minHeap.size() > 1) {
            minHeap.add(Math.abs(minHeap.poll() - minHeap.poll()));
        }
        if (minHeap.size() == 1)
            return minHeap.peek();
        return 0;
    }
}
