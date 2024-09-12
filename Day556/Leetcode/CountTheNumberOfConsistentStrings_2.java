//Leetcode
//1684. Count the Number of Consistent Strings
//Time complexity: O((words.length*(lengthiest string in words).length)
//Space complexity: O(26) 

import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfConsistentStrings_2 {

    public static void main(String[] args) {
        String allowed = "abc";
        String[] words = { "a", "b", "c", "ab", "ac", "bc", "abc" };
        System.out.println(countConsistentStrings(allowed, words));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int count = 0;
        for (String k : words) {
            int flag = 1;
            for (int i = 0; i < k.length(); i++) {
                if (!set.contains(k.charAt(i))) {
                    flag = 0;
                    break;
                }
            }
            count += flag;
        }
        return count;
    }
}
