//GFG
//Group Balls by Sequence
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.TreeMap;

public class GroupBallsBySequence {

    public static void main(String[] args) {
        int arr[] = { 10, 1, 2, 11 };
        int k = 2;
        System.out.println(validgroup(arr, k));
    }

    public static boolean validgroup(int[] arr, int k) {
        // code here
        if (arr.length % k != 0)
            return false;

        TreeMap<Integer, Integer> countMap = new TreeMap<>();

        // Count frequencies
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        while (!countMap.isEmpty()) {
            int first = countMap.firstKey();

            for (int i = 0; i < k; i++) {
                int num = first + i;
                if (!countMap.containsKey(num)) {
                    return false;
                }
                countMap.put(num, countMap.get(num) - 1);
                if (countMap.get(num) == 0) {
                    countMap.remove(num);
                }
            }
        }

        return true;
    }
}
