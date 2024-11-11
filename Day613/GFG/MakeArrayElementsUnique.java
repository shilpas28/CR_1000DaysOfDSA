//GFG
//Make array elements unique
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class MakeArrayElementsUnique {

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3 };
        System.out.println(minIncrements(arr));
    }

    public static int minIncrements(int[] arr) {
        // Code here
        Arrays.sort(arr);
        int increments = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] <= arr[i - 1]) {
                int incrementNeeded = arr[i - 1] - arr[i] + 1;
                arr[i] += incrementNeeded;
                increments += incrementNeeded;
            }
        }
        return increments;
    }
}
