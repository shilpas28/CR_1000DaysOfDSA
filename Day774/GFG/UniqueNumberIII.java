//GFG
//Unique Number III
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.HashMap;

public class UniqueNumberIII {

    public static void main(String[] args) {
        int arr[] = { 1, 10, 1, 1 };
        System.out.println(getSingle(arr));
    }

    public static int getSingle(int[] arr) {
        // code here
        int val = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (hm.get(arr[i]) == 1) {
                val = arr[i];
            }
        }
        return val;
    }
}
