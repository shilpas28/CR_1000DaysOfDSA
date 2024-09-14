//GFG
//Alternate positive and negative numbers - Using Queue
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlternatePositiveAndNegativeNumbers_2 {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(9);
        arr.add(4);
        arr.add(-2);
        arr.add(-1);
        arr.add(5);
        arr.add(0);
        arr.add(-5);
        arr.add(-3);
        arr.add(2);
        rearrange(arr);
        System.out.println(arr);
    }

    static void rearrange(ArrayList<Integer> arr) {
        // code here
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();

        for (int i : arr) {
            if (i >= 0)
                pos.add(i);
            else
                neg.add(i);
        }

        int i = 0;
        while (!pos.isEmpty() && !neg.isEmpty()) {
            arr.set(i++, pos.poll());
            arr.set(i++, neg.poll());
        }
        while (!pos.isEmpty())
            arr.set(i++, pos.poll());
        while (!neg.isEmpty())
            arr.set(i++, neg.poll());
    }
}
