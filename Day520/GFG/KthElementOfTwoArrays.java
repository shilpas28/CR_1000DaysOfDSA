//GFG
//K-th element of two Arrays
//Time complexity: O(log(n) + log(m))
//Space complexity: O(log(n))

import java.util.Arrays;

public class KthElementOfTwoArrays {

    public static void main(String[] args) {
        int k = 5;
        int arr1[] = { 2, 3, 6, 7, 9 };
        int arr2[] = { 1, 4, 8, 10 };
        System.out.println(kthElement(k, arr1, arr2));
    }

    public static long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int n = arr1.length + arr2.length;
        int res[] = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            res[i + arr1.length] = arr2[i];
        }
        Arrays.sort(res);
        return res[k - 1];
    }
}
