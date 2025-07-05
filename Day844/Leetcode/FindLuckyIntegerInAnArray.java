//Leetcode
//1394. Find Lucky Integer in an Array
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInAnArray {

    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 4 };
        System.out.println(findLucky(arr));
    }

    public static int findLucky(int[] arr) {

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        int result = -1;
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (num == count && num > result) {
                result = num;
            }
        }
        return result;
    }
}
