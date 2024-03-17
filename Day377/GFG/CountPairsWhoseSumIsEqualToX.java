//GFG
//Count Pairs whose sum is equal to X
//Time complexity: O(length(head1)+length(head2))
//Space complexity: O(length(head1)) or O(length(head2))

package GFG;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class CountPairsWhoseSumIsEqualToX {

    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> head1 = new LinkedList<>();
        head1.add(1);
        head1.add(2);
        head1.add(3);
        head1.add(4);
        head1.add(5);
        head1.add(6);

        LinkedList<Integer> head2 = new LinkedList<>();
        head2.add(11);
        head2.add(12);
        head2.add(13);

        int x = 15;
        System.out.println(countPairs(head1, head2, x));
    }

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
            int x) {
        // add your code here
        HashSet<Integer> set = new HashSet<>();
        Iterator<Integer> itr1 = head1.iterator();
        while (itr1.hasNext())
            set.add(itr1.next());

        Iterator<Integer> itr2 = head2.iterator();
        int cnt = 0;
        while (itr2.hasNext()) {
            if (set.contains(x - itr2.next()))
                ++cnt;
        }
        return cnt;
    }
}
