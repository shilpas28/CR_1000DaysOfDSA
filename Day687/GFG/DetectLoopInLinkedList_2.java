//GFG
//Detect Loop in linked list - Optimal
//Time complexity: O(N), where N is the number of nodes in the linked list. This is because in the worst-case scenario, the fast 
//pointer, which moves quicker, will either reach the end of the list (in case of no loop) or meet the slow pointer (in case of a 
//loop) in a linear time relative to the length of the list. The key insight into why this is O(N) and not something slower is 
//that each step of the algorithm reduces the distance between the fast and slow pointers (when they are in the loop) by one. 
//Therefore, the maximum number of steps needed for them to meet is proportional to the number of nodes in the list.
//Space complexity: O(1) The code uses only a constantamount of additionalspace, regardless of the linked list's length. This is 
//achieved by using two pointers (slow and fast) to detect the loop without any significant extra memory usage, resulting in 
//constantspace complexity, O(1).

public class DetectLoopInLinkedList_2 {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = head.next;
        System.out.println(detectLoop(head));
    }

    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        // Add code here
        // Initialize two pointers, slow and fast,
        // to the head of the linked list
        Node slow = head;
        Node fast = head;
        // Step 2: Traverse the linked list
        // with the slow and fast pointers
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;
            // Check if slow and fast pointers meet
            if (slow == fast) {
                return true; // Loop detected
            }
        }
        // If fast reaches the end of the
        // list, there is no loop
        return false;
    }
}
