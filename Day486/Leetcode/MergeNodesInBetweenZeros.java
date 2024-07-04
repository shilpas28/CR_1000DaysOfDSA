//Leetcode
//2181. Merge Nodes in Between Zeros
//Time complexity: O(N)
//Space complexity: O(N)

public class MergeNodesInBetweenZeros {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);
        ListNode res = mergeNodes(head);
        printList(res);
    }

    public static ListNode mergeNodes(ListNode head) {
        // BASE CASE -> if we have a single zero, simply return null
        if (head.next == null) return null;
        // fetch sum from current 0 to next 0
        ListNode ptr = head.next;
        int sum = 0;
        while (ptr.val != 0) {
            sum += ptr.val;
            ptr = ptr.next;
        }
        // assign sum on the first node between nodes having value 0
        head.next.val = sum;
        // call and get the answer and connect the answer to next of head->next
        head.next.next = mergeNodes(ptr);
        // return head->next..=> new head
        return head.next;
    }

    static void printList(ListNode head) 
    { 
        ListNode currNode = head; 
        System.out.print("LinkedList: "); 
        while (currNode != null) { 
            System.out.print(currNode.val + " "); 
            currNode = currNode.next; 
        } 
    } 
}
