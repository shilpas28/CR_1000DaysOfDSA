//GFG
//Reverse a Stack
//Time complexity: O(N)
//Space complexity: O(N) 

package GFG;

import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> St = new Stack<Integer>();
        St.add(3);
        St.add(2);
        St.add(1);
        St.add(7);
        St.add(6);
        reverse(St);
        System.out.println(St);
    }

    static void reverse(Stack<Integer> s) {
        // add your code here
        if (s.isEmpty())
            return;
        int el = s.pop();
        reverse(s);
        insertAtLast(s, el);
    }

    static void insertAtLast(Stack<Integer> s, int val) {
        if (s.isEmpty()) {
            s.add(val);
            return;
        }
        int el = s.pop();
        insertAtLast(s, val);
        s.add(el);
    }
}
