//Leetcode
//2336. Smallest Number in Infinite Set
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SmallestNumberInInfiniteSet {

    public static void main(String[] args) {
        
    }

    static int cur;
    static Set<Integer> s;

    public static void SmallestInfiniteSet() {
        cur = 1;
        s = new HashSet<>();
    }

    public static int popSmallest() {
        if (!s.isEmpty()) {
            int res = Collections.min(s);
            s.remove(res);
            return res;
        } else {
            cur++;
            return cur - 1;
        }
    }

    public static void addBack(int num) {
        if (cur > num) {
            s.add(num);
        }
    }
}
