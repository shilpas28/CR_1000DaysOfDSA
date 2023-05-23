//Leetcode
//703. Kth Largest Element in a Stream
//Time complexity: --> Construction: O(N * logK) and Adding: O(logK)
//Space complexity: O(K) (can be reduced to O(1) by reusing memory of the existing array)

package Leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    static class KthLargest {

        final PriorityQueue<Integer> q;
        final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            q = new PriorityQueue<>(k);
            for (int n : nums)
                add(n);
        }

        public int add(int n) {
            if (q.size() < k)
                q.offer(n);
            else if (q.peek() < n) {
                q.poll();
                q.offer(n);
            }
            return q.peek();
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8
    }

}
