//Leetcode
//1346. Check If N and Its Double Exist - Using HashMap
//Time complexity: O(N^2) , HashMap.containsKey() costs O(n) at worst case.
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class CheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        int[] arr = { 10, 2, 5, 3 };
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++)
            map.put(arr[i], i);

        for (int i = 0; i < n; i++) {
            if (map.containsKey(2 * arr[i]) &&
                    map.get(2 * arr[i]) != i) {
                return true;
            }
        }
        return false;
    }
}
