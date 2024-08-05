//Leetcode
//2053. Kth Distinct String in an Array - Optimized Two-Set Approach
//Time complexity: O(n)
//Space complexity: O(n)

import java.util.HashSet;
import java.util.Set;

public class KthDistinctStringInAnArray_3 {

    public static void main(String[] args) {
        String[] arr = { "d", "b", "c", "b", "c", "a" };
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }

    public static String kthDistinct(String[] arr, int k) {
        Set<String> distinct = new HashSet<>();
        Set<String> nonDistinct = new HashSet<>();

        for (String s : arr) {
            if (!nonDistinct.contains(s)) {
                if (!distinct.add(s)) {
                    distinct.remove(s);
                    nonDistinct.add(s);
                }
            }
        }

        if (distinct.size() < k)
            return "";
        for (String s : arr) {
            if (distinct.contains(s) && --k == 0) {
                return s;
            }
        }
        return "";
    }
}
