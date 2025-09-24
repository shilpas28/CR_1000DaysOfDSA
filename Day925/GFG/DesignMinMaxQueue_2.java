//GFG
//Design MinMax Queue
//Time complexity:
//Space complexity:

import java.util.ArrayDeque;
import java.util.Iterator;

public class DesignMinMaxQueue_2 {

    static class SpecialQueue {

        private ArrayDeque<Integer> q;
        private int min;
        private int max;

        public SpecialQueue() {
            // Define Data Structures
            q = new ArrayDeque<>();
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }

        public void enqueue(int x) {
            // Insert element into the queue
            max = Math.max(max, x);
            min = Math.min(min, x);
            q.offer(x);
        }

        public void dequeue() {
            // Remove element from the queue
            q.poll();

            // Reset
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            Iterator<Integer> it = q.iterator();
            while (it.hasNext()) {
                Integer curr = it.next();
                max = Math.max(max, curr);
                min = Math.min(min, curr);
            }
        }

        public int getFront() {
            // Get front element
            return q.peek();
        }

        public int getMin() {
            // Get minimum element
            return min;
        }

        public int getMax() {
            // Get maximum element
            return max;
        }
    }

    public static void main(String[] args) {

    }
}
