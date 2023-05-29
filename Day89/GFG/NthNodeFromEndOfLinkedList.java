//GFG
//Nth node from end of linked list
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class NthNodeFromEndOfLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        int N = 2;
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        System.out.println(getNthFromLast(head, N));
    }

    // Function to find the data of nth node from the end of a linked list.
    static int getNthFromLast(Node head, int n) {
        // Your code here
        Node first=head,second=head;
    	int c=0;
    	while(first!=null){
    	    first=first.next;
    	    c++;
    	    if(c>n)second=second.next;
    	}
    	if(c<n)return -1;
    	return second.data;
    }
}
