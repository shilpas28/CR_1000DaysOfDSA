//Leetcode
//386. Lexicographical Numbers - Brute Force
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicographicalNumbers {

    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        Collections.sort(res, (a, b) -> (Integer.toString(a).compareTo(Integer.toString(b)))); // comparing integers
                                                                                               // lexicographically
        return res;
    }
}
