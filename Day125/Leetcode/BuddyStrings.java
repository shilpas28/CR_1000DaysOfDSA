//Leetcode
//859. Buddy Strings
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyStrings {

    public static void main(String[] args) {
        String s = "ab", goal = "ba";
        System.out.println(buddyStrings(s, goal));
    }

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (set.contains(c))
                    return true;
                set.add(c);
            }
            return false;
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i))
                    list.add(i);
            }
            return list.size() == 2 && s.charAt(list.get(0)) == goal.charAt(list.get(1))
                    && s.charAt(list.get(1)) == goal.charAt(list.get(0));
        }
    }
}
