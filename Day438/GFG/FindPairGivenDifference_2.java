//GFG
//Find Pair Given Difference
//Time complexity: O(n* Log(n))
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class FindPairGivenDifference_2 {

    public static void main(String[] args) {
        int n = 6;
        int x = 78;
        int arr[] = { 5, 20, 3, 2, 5, 80 };
        System.out.println(findPair(n, x, arr));
    }

    public static int findPair(int n, int x, int[] arr) {
        // code here
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        while (i < n && j < n) {
            if (i != j && arr[j] - arr[i] == x)
                // to handle target as 0, arr[] = 1 2 3 4 5
                return 1;
            else if (arr[j] - arr[i] < x)
                j++;
            else
                i++;

        }
        return -1;
    }
}
