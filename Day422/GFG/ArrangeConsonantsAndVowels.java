//GFG
//Arrange Consonants and Vowels
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class ArrangeConsonantsAndVowels {

    static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node('a');
        head.next = new Node('b');
        head.next.next = new Node('c');
        head.next.next.next = new Node('d');
        head.next.next.next.next = new Node('e');
        head.next.next.next.next.next = new Node('f');
        head.next.next.next.next.next.next = new Node('g');
        head.next.next.next.next.next.next.next = new Node('h');
        head.next.next.next.next.next.next.next.next = new Node('i');
        Node res = arrangeCV(head);
        printList(res);
    }

    public static Node arrangeCV(Node head) {
        // write code here and return the head of changed linked list
        if (head == null || head.next == null)
            return head;
        Node first = null;
        Node second = head;
        if (isVowel(head.data))
            first = head;
        while (second.next != null) {
            if (isVowel(second.next.data)) {
                if (first == second) {
                    first = first.next;
                    second = second.next;
                } else if (first == null) {
                    first = second.next;
                    second.next = second.next.next;
                    first.next = head;
                    head = first;
                } else {
                    Node a = first.next;
                    first.next = second.next;
                    second.next = second.next.next;
                    first.next.next = a;
                    first = first.next;
                }
            } else {
                second = second.next;
            }
        }
        return head;
    }

    static boolean isVowel(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
            return true;
        return false;
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
