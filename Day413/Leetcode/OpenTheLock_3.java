//Leetcode
//752. Open the Lock - Improved 2 end solution
//Time complexity: O(N^2)
//Space complexity: O(N^2)

package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OpenTheLock_3 {

    public static void main(String[] args) {
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        begin.add("0000");
        end.add(target);
        int level = 0;
        Set<String> temp;
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                temp = begin;
                begin = end;
                end = temp;
            }
            temp = new HashSet<>();
            for (String s : begin) {
                if (end.contains(s))
                    return level;
                if (deads.contains(s))
                    continue;
                deads.add(s);
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < 4; i++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if (!deads.contains(s1))
                        temp.add(s1);
                    if (!deads.contains(s2))
                        temp.add(s2);
                }
            }
            level++;
            begin = temp;
        }
        return -1;
    }
}
