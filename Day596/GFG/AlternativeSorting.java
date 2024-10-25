//GFG
//Alternative Sorting
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;

public class AlternativeSorting {

    public static void main(String[] args) {
        int[] arr = { 7, 1, 2, 3, 4, 5, 6 };
        System.out.println(alternateSort(arr));
    }

    public static ArrayList<Integer> alternateSort(int[] arr) {
        // Your code goes here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        for (int k = 0; k < n; k++) {
            if (k % 2 == 1)
                ans.add(arr[i++]);
            else
                ans.add(arr[j--]);
        }
        return ans;
    }
}
