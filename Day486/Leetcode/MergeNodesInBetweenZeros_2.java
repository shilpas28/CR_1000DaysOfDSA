//Leetcode
//2181. Merge Nodes in Between Zeros
//Time complexity: O(N)
//Space complexity: O(1)

public class MergeNodesInBetweenZeros_2 {
    
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
        ListNode dummy = new ListNode(), cur = dummy;
        head = head.next;
        int sum = 0;
        while(head != null) {
            if(head.val == 0) {
                cur.next = new ListNode(sum);
                cur = cur.next;
                sum = 0;
            } 
            sum += head.val;
            head = head.next;
        }
        return dummy.next;
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
