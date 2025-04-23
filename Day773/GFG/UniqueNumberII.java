//GFG
//Unique Number II
//Time complexity: O(NlogN)
//Space complexity: O(1) 

import java.util.Arrays;
import java.util.HashSet;

public class UniqueNumberII {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 2, 1, 4 };
        System.out.println(Arrays.toString(singleNum(arr)));
    }

    public static int[] singleNum(int[] arr) {
        // Code here
        HashSet<Integer> map = new HashSet<>();
        for (int i : arr) {
            if (map.contains(i))
                map.remove(i);
            else
                map.add(i);
        }

        int[] array = new int[2];
        int i = 0;
        for (int val : map) {
            array[i] = val;
            i++;
        }

        Arrays.sort(array);
        return array;
    }
}
