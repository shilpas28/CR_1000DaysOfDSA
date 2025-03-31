//GFG
//Maximize partitions in a String
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.List;

public class MaximizePartitionsInAString {

    public static void main(String[] args) {
        String s = "acbbcc";
        System.out.println(maxPartitions(s));
    }

    public static int maxPartitions(String s) {
        // code here
        int[] lastOccurrence = new int[26];
        int idx = 0;
        for (char c : s.toCharArray()) {
            lastOccurrence[c - 'a'] = idx;
            idx++;
        }

        List<Integer> ans = new ArrayList<>();
        idx = 0;
        int st = 0, n = s.length();
        while (idx < n) {
            st = getMax(s, lastOccurrence, idx);
            ans.add(st - idx + 1);
            idx = st + 1;
        }
        return ans.size();
    }

    static int getMax(String str, int[] lastOccurence, int s) {
        int l = Math.max(s, lastOccurence[str.charAt(s) - 'a']), m = l;
        while (s <= Math.max(m, l)) {
            m = Math.max(m, lastOccurence[str.charAt(s) - 'a']);
            s++;
        }
        return m;
    }
}
