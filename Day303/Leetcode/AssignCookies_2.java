//leetcode
//455. Assign Cookies
//Time complexity: O(nlogn)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class AssignCookies_2 {

    public static void main(String[] args) {
        int[] g = { 1, 2 };
        int[] s = { 1, 2, 3 };
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int index = 0;
        int cnt = 0;

        while (index < s.length && cnt < g.length) {
            if (s[index] >= g[cnt]) {
                cnt++;
            }
            index++;
        }

        return cnt;
    }
}
