//Leetcode
//1331. Rank Transform of an Array
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.HashMap;

public class RankTransformOfAnArray {

    public static void main(String[] args) {
        int[] arr = { 40, 10, 20, 30 };
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }

    public static int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] array = Arrays.copyOf(arr, arr.length);
        Arrays.sort(array);
        int k = 1;
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i]))
                map.put(array[i], k++);
        }
        int[] result = new int[array.length];
        for (int i = 0; i < arr.length; i++)
            result[i] = map.get(arr[i]);
        return result;
    }
}
