//GFG
//Merge Without Extra Space
//Time complexity: O((M+N)log(M+N))
//Space complexity: O(M+N)

import java.util.Arrays;

public class MergeWithoutExtraSpace {

    public static void main(String[] args) {
        int a[] = { 2, 4, 7, 10 };
        int b[] = { 2, 3 };
        mergeArrays(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    // Function to merge the arrays.
    public static void mergeArrays(int a[], int b[]) {
        // code here
        int n = a.length;
        int m = b.length;
        int i = 0, j = 0, k = n - 1;
        while (i <= k && j < m) {
            if (a[i] < b[j]) {
                i++;
            } else {
                int temp = a[k];
                a[k] = b[j];
                b[j] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
