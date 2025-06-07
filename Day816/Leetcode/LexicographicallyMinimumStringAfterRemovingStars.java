//Leetcode
//3170. Lexicographically Minimum String After Removing Stars
//Time complexity: O(n*log(26)) = O(n)  // O(log(26)) maintaining heap; O(n) to iterate the string
//Space complexity: O(26) + O(2*n) = O(n)  // O(26) heap; O(n) for indices vector and O(n) for result

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class LexicographicallyMinimumStringAfterRemovingStars {

    public static void main(String[] args) {
        String s = "aaba*";
        System.out.println(clearStars(s));
    }

    public static String clearStars(String s) {
        HashSet<Integer> removeSet = new HashSet<>();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        ArrayList<ArrayList<Integer>> indices = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 26; i++) {
            indices.add(new ArrayList<Integer>());
        }
        char ch;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                removeSet.add(i);
                ch = pq.peek();
                removeSet.add(indices.get((int) (ch - 'a')).get(indices.get((int) (ch - 'a')).size() - 1));
                indices.get((int) (ch - 'a')).remove(indices.get((int) (ch - 'a')).size() - 1);
                if (indices.get((int) (ch - 'a')).size() == 0) {
                    pq.poll();
                }
                continue;
            }
            if (indices.get((int) (s.charAt(i) - 'a')).size() == 0) {
                pq.add(s.charAt(i));
            }
            indices.get((int) (s.charAt(i) - 'a')).add(i);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removeSet.contains(i)) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
