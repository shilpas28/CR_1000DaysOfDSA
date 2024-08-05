//Leetcode
//2053. Kth Distinct String in an Array - Hash Set
//Time complexity: O(n)
//Space complexity: O(n)

import java.util.HashSet;
import java.util.Set;

public class KthDistinctStringInAnArray_2 {

    public static void main(String[] args) {
        String[] arr = { "d", "b", "c", "b", "c", "a" };
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }

    public static String kthDistinct(String[] arr, int k) {
        Set<String> distinct = new HashSet<>();
        Set<String> seen = new HashSet<>();

        for (String str : arr) {
            if (!seen.add(str)) {
                distinct.remove(str);
            } else {
                distinct.add(str);
            }
        }

        for (String str : arr) {
            if (distinct.contains(str) && --k == 0) {
                return str;
            }
        }
        return "";
    }
}
