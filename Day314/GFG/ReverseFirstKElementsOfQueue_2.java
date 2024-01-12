//GFG
//Reverse First K elements of Queue - Extra space is being taken. So method 1 is better.
//Time complexity: O(N)
//Space complexity: O(K)

package GFG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfQueue_2 {

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
        for (int i = 0; i < k; i++)
            st.push(q.poll());
        Queue<Integer> ans = new LinkedList<>();
        while (!st.isEmpty())
            ans.add(st.pop());
        while (!q.isEmpty())
            ans.add(q.poll());
        return ans;
    }
}
