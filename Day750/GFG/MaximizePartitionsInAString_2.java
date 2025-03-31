//GFG
//Maximize partitions in a String
//Time complexity: O(N) where N is the length of the string. We traverse the string twice (once to determine last occurrences, 
//once to count partitions), making the approach linear.
//Space complexity: O(1) since we only store the last occurrence index of each character, which is at most 26 entries for lowercase 
//English letters.

import java.util.HashMap;
import java.util.Map;

public class MaximizePartitionsInAString_2 {

    public static void main(String[] args) {
        String s = "acbbcc";
        System.out.println(maxPartitions(s));
    }

    public static int maxPartitions(String s) {
        // code here
        int n = s.length();
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            lastIndex.put(s.charAt(i), i);
        }
        int ans = 0, ind = 0;
        for (int i = 0; i < n; i++) {
            ind = Math.max(ind, lastIndex.get(s.charAt(i)));
            if (ind == i) {
                ans++;
            }
        }
        return ans;
    }
}
