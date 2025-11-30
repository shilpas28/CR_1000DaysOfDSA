//GFG
//Count of distinct substrings
//Time complexity: O(N^2)
//Space complexity: O(N^2)

public class CountOfDistinctSubstrings_2 {

    public static void main(String[] args) {
        String s = "ababa";
        System.out.println(countSubs(s));
    }

    static class Node {

        Node[] children = new Node[26];

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static int countSubs(String s) {
        // code here
        Node root = new Node();
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            Node curr = root;
            for (int j = i; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                if (curr.children[index] == null) {
                    counter++;
                    curr.children[index] = new Node();
                }
                curr = curr.children[index];
            }
        }
        return counter;
    }
}
