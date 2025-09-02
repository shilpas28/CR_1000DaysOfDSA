//GFG
//Swap Kth nodes from ends
//Time complexity: O(N)
//Space complexity: O(1)

public class SwapKthNodesFromEnds {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(8);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(3);
        int k = 2;
        Node res = swapKth(head, k);
        printList(res);
    }

    public static Node swapKth(Node head, int k) {
        // code here
        if (head == null)
            return null;

        int n = 0;
        Node curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        // Step 2: If k is invalid
        if (k > n)
            return head;
        // Step 3: kth from start and kth from end are same
        if (2 * k - 1 == n)
            return head; // same node
        // Step 4: Find kth from start
        Node first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        // Step 5: Find kth from end (n-k+1 from start)
        Node second = head;
        for (int i = 1; i < n - k + 1; i++) {
            second = second.next;
        }
        // Step 6: Swap values
        int temp = first.data;
        first.data = second.data;
        second.data = temp;

        return head;
    }

    static void printList(Node res) {
        // A loop that runs till head is null
        while (res != null) {
            // Printing data of current node
            System.out.print(res.data);
            if (res.next != null)
                System.out.print("->");
            // Moving to the next node
            res = res.next;
        }
    }
}
