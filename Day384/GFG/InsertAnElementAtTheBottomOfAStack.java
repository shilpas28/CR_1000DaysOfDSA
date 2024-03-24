//GFG
//Insert an Element at the Bottom of a Stack
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.Stack;

public class InsertAnElementAtTheBottomOfAStack {

    public static void main(String[] args) {
        // int n = 5;
        int x = 2;
        Stack<Integer> st = new Stack<>();
        st.add(4);
        st.add(3);
        st.add(2);
        st.add(1);
        st.add(8);
        System.out.println(insertAtBottom(st, x));
    }

    public static Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        Stack<Integer> temp = new Stack<>();
        while (!st.isEmpty()) {
            temp.push(st.peek());
            st.pop();
        }
        st.push(x);
        while (!temp.isEmpty()) {
            st.push(temp.peek());
            temp.pop();
        }
        return st;
    }
}
