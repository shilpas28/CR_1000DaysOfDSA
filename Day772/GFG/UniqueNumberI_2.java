//GFG
//Unique Number I
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.HashMap;

public class UniqueNumberI_2 {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 5, 5 };
        System.out.println(findUnique(arr));
    }

    public static int findUnique(int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int s : arr) {
            if (map.get(s) == 1) {
                return s;
            }
        }
        return -1;
    }
}
