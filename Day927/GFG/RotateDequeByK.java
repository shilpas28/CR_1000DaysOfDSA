//GFG
//Rotate Deque By K
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.Deque;
import java.util.LinkedList;

public class RotateDequeByK {

    public static void main(String[] args) {
        // dq = [1, 2, 3, 4, 5, 6], type = 1, k = 2
        int type = 1, k = 2;
        Deque<Integer> dq = new LinkedList<Integer>();
        dq.add(1);
        dq.add(2);
        dq.add(3);
        dq.add(4);
        dq.add(5);
        dq.add(6);
        rotateDeque(dq, type, k);
        System.out.println(dq);
    }

    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        // code here
        int n = dq.size();
        k %= n;

        if (type == 1) {
            while (k-- != 0) {
                int ele = dq.pollLast();
                dq.offerFirst(ele);
            }

        } else if (type == 2) {
            while (k-- != 0) {
                int ele = dq.pollFirst();
                dq.offerLast(ele);
            }

        }
        return;
    }
}
