//GFG
//Queue Reversal
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(4);
        q.add(3);
        q.add(1);
        q.add(10);
        q.add(2);
        q.add(6);
        System.out.println(rev(q));
    }

    // Function to reverse the queue.
    public static Queue<Integer> rev(Queue<Integer> q) {
        // add code here.
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty())
            st.push(q.remove());
        while (!st.isEmpty())
            q.add(st.pop());
        return q;
    }
}
