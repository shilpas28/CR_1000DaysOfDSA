//GFG
//Linked List that is Sorted Alternatingly
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class LinkedListThatIsSortedAlternatingly_2 {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(9);
        root.next.next = new Node(2);
        root.next.next.next = new Node(8);
        root.next.next.next.next = new Node(3);
        root.next.next.next.next.next = new Node(7);
        Node res = sort(root);
        printList(res);
    }

    public static Node sort(Node head) {
        // your code here, return the head of the sorted list
        Node head1 = new Node(0), head2 = new Node(0);
        Node temp1 = head1, temp2 = head2, temp = head;
        boolean indication = true;
        while (temp != null) {
            if (indication) {
                temp1.next = temp;
                temp1 = temp1.next;
            } else {
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
            indication = !indication;
        }
        temp1.next = null;
        temp2.next = null;
        Node curr = head2, prev = null, nxt = head2.next;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        temp = prev;
        while (prev != null) {
            if (prev.next == head2) {
                prev.next = null;
            }
            prev = prev.next;
        }
        Node ans = new Node(0);
        head2 = ans;
        head1 = head1.next;
        while (head1 != null && temp != null) {
            if (head1.data <= temp.data) {
                ans.next = head1;
                head1 = head1.next;
            } else {
                ans.next = temp;
                temp = temp.next;
            }
            ans = ans.next;
        }
        while (head1 != null) {
            ans.next = head1;
            head1 = head1.next;
            ans = ans.next;
        }
        while (temp != null) {
            ans.next = temp;
            temp = temp.next;
            ans = ans.next;
        }
        return head2.next;
    }

    static void printList(Node head) {
        Node currNode = head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }

}
