//Leetcode
//1318. Minimum Flips to Make a OR b Equal to c
//Time complexity: O(1)
//Space complexity: O(1)

package Leetcode;

public class MinimumFlipsToMakeaORbEqualToc {

    public static void main(String[] args) {
        int a = 2, b = 6, c = 5;
        System.out.println(minFlips(a, b, c));
    }

    public static int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            boolean ai = false;
            boolean bi = false;
            boolean ci = false;
            if ((a & (1 << i)) > 0)
                ai = true;
            if ((b & (1 << i)) > 0)
                bi = true;
            if ((c & (1 << i)) > 0)
                ci = true;
            if (ci) {
                if (!ai && !bi)
                    ans++;
            } else {
                if (ai && bi)
                    ans += 2;
                else if (ai || bi)
                    ans++;
            }
        }
        return ans;
    }
}
