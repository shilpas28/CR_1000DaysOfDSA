//Leetcode
//264. Ugly Number II
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.TreeSet;

public class UglyNumberII_2 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }

    public static int nthUglyNumber(int n) {
        TreeSet<Long> t = new TreeSet<>();
        t.add(1L);
        int i = 1;
        while (i < n) {
            long temp = t.pollFirst();
            t.add(temp * 2);
            t.add(temp * 3);
            t.add(temp * 5);
            i++;
        }
        return t.pollFirst().intValue();
    }
}
