//Leetcode
//1625. Lexicographically Smallest String After Applying Operations - BFS
//Time complexity:
//Space complexity:

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LexicographicallySmallestStringAfterApplyingOperations {

    public static void main(String[] args) {
        String s = "5525";
        int a = 9, b = 2;
        System.out.println(findLexSmallestString(s, a, b));
    }

    public static String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String smallest = s;
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        Set<String> seen = new HashSet<>(q);
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (smallest.compareTo(cur) > 0)
                smallest = cur;
            char[] ca = cur.toCharArray();
            for (int i = 1; i < ca.length; i += 2) // add operation.
                ca[i] = (char) ((ca[i] - '0' + a) % 10 + '0');
            String addA = String.valueOf(ca);
            if (seen.add(addA))
                q.offer(addA);
            String rotate = cur.substring(n - b) + cur.substring(0, n - b); // rotation.
            if (seen.add(rotate))
                q.offer(rotate);
        }
        return smallest;
    }
}
