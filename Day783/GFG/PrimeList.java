//GFG
//Prime List
//Time complexity: O(n * sqrt(node.val))
//Space complexity: O(1)

package GFG;

public class PrimeList {

    static class Node {
        Node next;
        int val;

        public Node(int data) {
            val = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(6);
        head.next.next = new Node(10);
        Node res = primeList(head);
        printList(res);
    }

    static Node primeList(Node head) {
        // code here
        Node temp = head;
        while (temp != null) {
            int data = check(temp.val);
            temp.val = data;
            temp = temp.next;
        }
        return head;
    }

    static int check(int n) {
        int i = n;
        int j = n;
        while (i >= 2) {
            if (isprime(i))
                return i;
            if (isprime(j))
                return j;
            i--;
            j++;
        }
        return 2;
    }

    static boolean isprime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
