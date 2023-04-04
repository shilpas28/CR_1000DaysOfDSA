//Leetcode
//2405. Optimal Partition of String
//Time complexity: O(N)
//Space complexity: O(26)

package Leetcode;

import java.util.HashSet;

public class OptimalPartitionOfString {

    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println(partitionString(s));
    }

    public static int partitionString(String s) {
        HashSet<Character> st = new HashSet<>();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (st.contains(s.charAt(i))) {
                ++count;
                st.clear();
            }
            st.add(s.charAt(i));
        }
        return count;
    }
}
