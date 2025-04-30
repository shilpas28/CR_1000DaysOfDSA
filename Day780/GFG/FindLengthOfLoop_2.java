//GFG
//Find length of Loop
//Time complexity: O(N) - The code traverses the entire linked list once, where 'n' is the number of nodes in the list. 
//This traversal has a linear time complexity, O(n). 
//Space complexity: O(1) - The code uses only a constant amount of additional space, regardless of the linked list's length. This is 
//achieved by using two pointers (slow and fast) to detect the loop without any significant extra memory usage, resulting in constant 
//space complexity, O(1).

public class FindLengthOfLoop_2 {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(25);
        head.next = new Node(14);
        head.next.next = new Node(19);
        head.next.next.next = new Node(33);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(21);
        head.next.next.next.next.next.next = new Node(39);
        head.next.next.next.next.next.next.next = new Node(90);
        head.next.next.next.next.next.next.next.next = new Node(58);
        head.next.next.next.next.next.next.next.next.next = new Node(45);
        head.next.next.next.next.next.next.next.next.next.next = head.next.next.next;
        System.out.println(countNodesinLoop(head));
    }

    // Function to find the length of a loop in the linked list.
    public static int countNodesinLoop(Node head) {
        // code here.
        Node slow = head;
        Node fast = head;
        // Step 1: Traverse the list to detect a loop
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;
            // Step 2: If the slow and fast
            // pointers meet, there is a loop
            if (slow == fast) {
                return findLength(slow, fast);
            }
        }
        // Step 3: If the fast pointer reaches the end
        // there is no loop
        return 0;
    }

    // Function to return the lenght
    // of loop when slow and fast are
    // on the same node
    static int findLength(Node slow, Node fast) {
        // count to keep track of
        // nodes encountered in loop
        int cnt = 1;
        // move fast by one step
        fast = fast.next;
        // traverse fast till it
        // reaches back to slow
        while (slow != fast) {
            // at each node increase
            // count by 1 and move fast
            // forward by one step
            cnt++;
            fast = fast.next;
        }
        // loop terminates when fast reaches
        // slow again and the count is returned
        return cnt;
    }
}
