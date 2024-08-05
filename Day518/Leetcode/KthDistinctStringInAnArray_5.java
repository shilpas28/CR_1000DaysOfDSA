//Leetcode
//2053. Kth Distinct String in an Array - LinkedHashMap for Order Preservation
//Time complexity: O(n)
//Space complexity: O(n) 

import java.util.LinkedHashMap;
import java.util.Map;

public class KthDistinctStringInAnArray_5 {

    public static void main(String[] args) {
        String[] arr = { "d", "b", "c", "b", "c", "a" };
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }

    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> orderMap = new LinkedHashMap<>();

        for (String str : arr) {
            orderMap.put(str, orderMap.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
            if (entry.getValue() == 1 && --k == 0) {
                return entry.getKey();
            }
        }
        return "";
    }
}
