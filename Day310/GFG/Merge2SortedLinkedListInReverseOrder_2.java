//GFG
//Merge 2 sorted linked list in reverse order
//Time complexity: O(N+M)
//Space complexity: O(1)

public class Merge2SortedLinkedListInReverseOrder_2 {

    // Structure of the node
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        // int N = 2, M = 2;
        Node list1 = new Node(1);
        list1.next = new Node(3);
        Node list2 = new Node(2);
        list2.next = new Node(4);
        Node res = mergeResult(list1, list2);
        printList(res);
    }

    static Node mergeResult(Node node1, Node node2) {
        // Your code here
        node1 = reverseLinkedList(node1);
        node2 = reverseLinkedList(node2);
        Node temp = new Node(0);
        Node ans = temp;
        while (node1 != null && node2 != null) {
            if (node1.data > node2.data) {
                ans.next = node1;
                node1 = node1.next;
            } else {
                ans.next = node2;
                node2 = node2.next;

            }
            ans = ans.next;
        }
        if (node1 != null)
            ans.next = node1;
        if (node2 != null)
            ans.next = node2;
        return temp.next;
    }

    static Node reverseLinkedList(Node head) {
        Node prev = null, curr = head, nxt;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    static void printList(Node head) {
        Node currNode = head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
}
