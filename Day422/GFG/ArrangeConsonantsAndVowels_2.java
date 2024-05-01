//GFG
//Arrange Consonants and Vowels
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class ArrangeConsonantsAndVowels_2 {

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
        Node vowel = new Node('a'), con = new Node('b');
        Node vowelH = vowel, conH = con;
        while (head != null) {
            char temp = head.data;
            if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
                vowel.next = head;
                vowel = vowel.next;
            } else {
                con.next = head;
                con = con.next;
            }
            head = head.next;
        }
        con.next = null;
        vowel.next = conH.next;
        return vowelH.next;
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
