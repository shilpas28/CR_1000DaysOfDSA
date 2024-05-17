//GFG
//Find Pair Given Difference
//Time complexity: O(n* Log(n))
//Space complexity: O(1)

package GFG;

import java.util.HashSet;

public class FindPairGivenDifference_3 {

    public static void main(String[] args) {
        int n = 6;
        int x = 78;
        int arr[] = { 5, 20, 3, 2, 5, 80 };
        System.out.println(findPair(n, x, arr));
    }

    public static int findPair(int n, int x, int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i] - x) || set.contains(arr[i] + x))
                return 1;
            else
                set.add(arr[i]);
        }
        return -1;
    }
}
