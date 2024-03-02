//GFG
//First element to occur k times
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

import java.util.HashMap;

public class FirstElementToOccurKTimes {

    public static void main(String[] args) {
        int n = 7, k = 2;
        int a[] = { 1, 7, 4, 3, 4, 8, 7 };
        System.out.println(firstElementKTime(n, k, a));
    }

    public static int firstElementKTime(int n, int k, int[] a) {
        HashMap<Integer, Integer> mm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mm.putIfAbsent(a[i], 0);
            mm.put(a[i], mm.get(a[i]) + 1);
            if (mm.get(a[i]) == k)
                return a[i];
        }
        return -1;
    }
}
