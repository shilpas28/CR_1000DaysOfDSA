//GFG
//Delete nodes having greater value on right
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class DeleteNodesHavingGreaterValueOnRight {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        // 12->15->10->11->5->6->2->3
        Node head = new Node(12);
        head.next = new Node(15);
        head.next.next = new Node(10);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(3);
        Node res = compute(head);
        Node currNode = res;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }

    }

    static Node compute(Node head) {
        // your code here
        Node rev = reverse(head);
        Node ans = new Node(-1);
        Node ptr = ans;
        while (rev != null) {
            if (rev.data >= ptr.data) {
                ptr.next = rev;
                ptr = ptr.next;
            }
            rev = rev.next;
        }
        ptr.next = null;
        return reverse(ans.next);
    }

    static Node reverse(Node head) {
        Node prev = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
