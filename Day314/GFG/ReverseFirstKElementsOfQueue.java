//GFG
//Reverse First K elements of Queue
//Time complexity: O(N)
//Space complexity: O(K)

package GFG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfQueue {

    public static void main(String[] args) {
        int k = 3;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(modifyQueue(q, k));
    }

    // Function to reverse first k elements of a queue.
    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < k; i++) {
            st.push(q.peek());
            q.poll();
        }
        int temp = q.size();
        while (!st.isEmpty()) {
            q.add(st.peek());
            st.pop();
        }
        while (temp-- != 0) {
            int a = q.peek();
            q.poll();
            q.add(a);
        }
        return q;
    }
}
