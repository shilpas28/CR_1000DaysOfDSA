//Find Anagrams In Linked List
//GFG
//Code not working here, need to debug (but accepted by GFG)
//Time complexity:
//Sapce complexity:

package Day9.GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAnagramsInLinkedlist {
    static class Node {
        char data;
        Node next;

        Node(char x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node('a');
        head.next = new Node('b');
        head.next.next = new Node('c');
        head.next.next.next = new Node('a');
        head.next.next.next.next = new Node('d');
        head.next.next.next.next.next = new Node('b');
        head.next.next.next.next.next.next = new Node('c');
        head.next.next.next.next.next.next.next = new Node('a');
        System.out.println(findAnagrams(head, null));

    }

    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        ArrayList<Node> ans = new ArrayList<>();

        Node st = head, end = head;
        int i=0,j=0;
        int[] map = new int[26];
        int[] curMap = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        while (end != null) {
            if (j < s.length() - 1) {
                curMap[end.data - 'a']++;
                j++;
                end = end.next;
            } else {
                curMap[end.data - 'a']++;
                j++;

                if (areEqual(map, curMap)) {
                    ans.add(st);
                    Node next = end.next;
                    end.next = null;

                    i = 0;
                    j = 0;
                    st = next;
                    end = next;
                    
                    Arrays.fill(curMap, 0);
                } else {
                    curMap[st.data - 'a']--;
                    i++;
                    st = st.next;
                    end = end.next;
                }
            }
        }
        return ans;
    }

    public static boolean areEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }
}
