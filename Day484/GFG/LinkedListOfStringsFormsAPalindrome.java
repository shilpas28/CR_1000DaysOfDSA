//GFG
//Linked list of strings forms a palindrome
//Time complexity:
//Space complexity:

public class LinkedListOfStringsFormsAPalindrome {

    static class Node {
        String data;
        Node next;

        Node(String x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node("a");
        root.next = new Node("bc");
        root.next.next = new Node("d");
        root.next.next.next = new Node("dcb");
        root.next.next.next.next = new Node("a");
        System.out.println(compute(root));
    }

    public static boolean compute(Node root) {
        StringBuilder temp = new StringBuilder();
        while (root != null) {
            temp.append(root.data);
            root = root.next;
        }
        String concat = temp.toString();
        int i = 0, j = concat.length() - 1;
        while (i < j) {
            if (concat.charAt(i) != concat.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
