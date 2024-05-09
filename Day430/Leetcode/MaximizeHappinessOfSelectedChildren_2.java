//Leetcode
//3075. Maximize Happiness of Selected Children - Priority Queue (Max Heap)
//Time complexity: O(nlogn+klogn), where n is the length of the happiness array, building priority queue takes nlogn and each iteration 
//we are popping one element which taken logk so for k element klogk
//Space complexity: O(n) where n is the length of the happiness array.

package Leetcode;

import java.util.PriorityQueue;

public class MaximizeHappinessOfSelectedChildren_2 {

    public static void main(String[] args) {
        int[] happiness = { 1, 2, 3 };
        int k = 2;
        System.out.println(maximumHappinessSum(happiness, k));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((x, y) -> (y - x));
        for (int i = 0; i < n; i++)
            maxheap.add(happiness[i]);
        long maxHappiness = 0;
        for (int i = 0; i < k; i++)
            maxHappiness += Math.max(maxheap.poll() - i, 0);
        return maxHappiness;
    }
}
