//GFG
//Merge Without Extra Space
//Time complexity: O((M+N)log(M+N))
//Space complexity: O(M+N)

package GFG;

import java.util.Arrays;

public class MergeWithoutExtraSpace {

    public static void main(String[] args) {
        int n = 4, m = 5;
        long arr1[] = { 1, 3, 5, 7 };
        long arr2[] = { 0, 2, 6, 8, 9 };
        merge(arr1, arr2, n, m);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    // Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) {
        // code here
        int i = 0, j = 0, k = n - 1;
        while (i <= k && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                long temp = arr1[k];
                arr1[k] = arr2[j];
                arr2[j] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
