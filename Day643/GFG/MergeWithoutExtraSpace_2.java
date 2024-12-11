//GFG
//Merge Without Extra Space
//Time complexity: O((N+M)log(N+M)) 
//Space complexity: O(1) 

import java.util.Arrays;

public class MergeWithoutExtraSpace_2 {

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
        int l = n + m;
        int gap = (l / 2) + (l % 2);
        while (gap > 0) {
            int st = 0;
            int end = st + gap;
            while (end < l) {
                // st in a and end in b
                if (st < n && end >= n) {
                    swap(a, b, st, end - n);
                }
                // st in b and end in b
                else if (st >= n)
                    swap(b, b, st - n, end - n);
                // st in a and end in a
                else
                    swap(a, a, st, end);
                st++;
                end++;
            }
            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    static void swap(int arr1[], int arr2[], int x1, int x2) {
        if (arr1[x1] > arr2[x2]) {
            int t = arr1[x1];
            arr1[x1] = arr2[x2];
            arr2[x2] = t;
        }
    }
}
