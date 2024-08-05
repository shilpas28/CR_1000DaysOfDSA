//Leetcode
//2053. Kth Distinct String in an Array - Hash Map
//Time complexity: O(n)
//Space complexity: O(m) where m is the number of unique strings in the input array

import java.util.HashMap;
import java.util.Map;

public class KthDistinctStringInAnArray_4 {

    public static void main(String[] args) {
        String[] arr = { "d", "b", "c", "b", "c", "a" };
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }

    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequency = new HashMap<>();

        for (String str : arr) {
            frequency.merge(str, 1, Integer::sum);
        }
        
        for (String str : arr) {
            if (frequency.get(str) == 1 && --k == 0) {
                return str;
            }
        }
        return "";
    }
}
