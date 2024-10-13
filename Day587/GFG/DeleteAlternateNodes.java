//GFG
//Delete Alternate Nodes
//Time complexity: O(N)
//Space complexity: O(1) 

public class DeleteAlternateNodes {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        printList(root);
        deleteAlt(root);
        printList(root);
    }

    public static void deleteAlt(Node head) {
        // Code Here
        while (head != null && head.next != null) {
            head.next = head.next.next;
            head = head.next;
        }
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
