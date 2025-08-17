//GFG
//Sort by Absolute Difference
//Time complexity: O(NlogN)
//Space complexity: O(1) (2 data structures for storage)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByAbsoluteDifference {

    public static void main(String[] args) {
        int x = 7;
        int arr[] = { 10, 5, 3, 9, 2 };
        rearrange(arr, x);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int[] arr, int x) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, Math.abs(x - i));
        }

        List<Integer> list = new ArrayList<>();
        for (int i : arr)
            list.add(i);

        Collections.sort(list, (a, b) -> Integer.compare(map.get(a), map.get(b)));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
}
