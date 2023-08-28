//Leetcode
//225. Implement Stack using Queues
//Time complexity:
//Space complexity:

package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    static class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            this.queue = new LinkedList<Integer>();
        }

        public void push(int x) {
            queue.add(x);
            for (int i = 0; i < queue.size() - 1; i++)
                queue.add(queue.poll());
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {

        // Your MyStack object will be instantiated and called as such:
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // return 2
        myStack.pop(); // return 2
        myStack.empty(); // return False
    }
}
