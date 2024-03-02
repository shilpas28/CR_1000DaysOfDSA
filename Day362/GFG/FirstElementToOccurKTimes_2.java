//GFG
//First element to occur k times
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

import java.util.HashMap;
import java.util.Map;

public class FirstElementToOccurKTimes_2 {

    public static void main(String[] args) {
        int n = 7, k = 2;
        int a[] = { 1, 7, 4, 3, 4, 8, 7 };
        System.out.println(firstElementKTime(n, k, a));
    }

    public static int firstElementKTime(int n, int k, int[] a) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int ele : a) {
            if (map.containsKey(ele))
                map.put(ele, map.get(ele) + 1);
            else
                map.put(ele, 1);
            if (map.get(ele) == k)
                return ele;
        }
        return -1;
    }
}
