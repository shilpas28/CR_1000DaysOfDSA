//Leetcode
//2558. Take Gifts From the Richest Pile
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile {

    public static void main(String[] args) {
        int gifts[] = { 25, 64, 9, 4, 100 };
        int k = 4;
        System.out.println(pickGifts(gifts, k));
    }

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : gifts)
            maxHeap.add(val);

        for (int i = 0; i < k && maxHeap.peek() > 1; i++) {
            int x = maxHeap.poll();
            maxHeap.add((int) Math.sqrt(x));
        }

        long sum = 0;
        for (int val : maxHeap)
            sum += val;

        return sum;
    }
}
