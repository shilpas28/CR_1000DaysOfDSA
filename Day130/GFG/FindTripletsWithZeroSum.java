//GFG
//Find triplets with zero sum
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class FindTripletsWithZeroSum {

    public static void main(String[] args) {
        int n = 5;
        int arr[] = {0, -1, 2, -3, 1};
        System.out.println(findTriplets(arr, n));
    }

    // arr[]: input array
    // n: size of the array
    // Function to find triplets with zero sum.
    public static boolean findTriplets(int arr[], int n) {
        // add code here.
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] > 0)
                    k--;
                else if (arr[i] + arr[j] + arr[k] < 0)
                    j++;
                else
                    return true;

            }
        }
        return false;
    }
}
