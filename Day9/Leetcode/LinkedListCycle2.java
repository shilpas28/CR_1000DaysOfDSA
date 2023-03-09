//142. Linked List Cycle II
//Leetcode - Brute Force
//Time complexity: O(N)
//Space complexity: O(N) as using hashset

import java.util.HashSet;

public class LinkedListCycle2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
             val = x;
            next = null;      
        }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        head.next=new ListNode(2);
        head.next.next=new ListNode(0);
        head.next.next.next=new ListNode(-4);
        head.next.next.next.next=head.next;
        System.out.println(detectCycle(head).val);
    }

    public static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> s=new HashSet<ListNode>(); 
        for(ListNode curr=head;curr!=null;curr=curr.next) {  
            if (s.contains(curr)) 
                return curr; 
            s.add(curr); 
        } 
        return null;  
    }
    

}
