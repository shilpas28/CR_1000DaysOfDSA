//GFG
//Queue Reversal
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(10);
        q.add(15);
        q.add(20);
        q.add(25);
        reverseQueue(q);
        System.out.println(q);
    }

    public static void reverseQueue(Queue<Integer> q) {
        // code here
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty())
            st.push(q.remove());
        while (!st.isEmpty())
            q.add(st.pop());
    }
}
