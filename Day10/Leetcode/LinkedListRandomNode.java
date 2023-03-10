//Leetcode
//382. Linked List Random Node
//time complexity: O(N)
//space complexity: O(N)
package Day10.Leetcode;

//import java.util.ArrayList;

public class LinkedListRandomNode {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // ArrayList<Integer> arr = new ArrayList<>();

    // static public Solution(ListNode head) {
    //     while(head!=null){
    //         arr.add(head.val);
    //         head=head.next;
    //     }
    // }

    // static public int getRandom() {
    //     return arr.get((int)(Math.random() * arr.size()));
    // }
}
