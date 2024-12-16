//GFG
//K-th element of two Arrays
//Time complexity: O(log(n) + log(m))
//Space complexity: O(log(n))

import java.util.Arrays;

public class KthElementOfTwoArrays {

    public static void main(String[] args) {
        int a[] = { 2, 3, 6, 7, 9 };
        int b[] = { 1, 4, 8, 10 };
        int k = 5;
        System.out.println(kthElement(a, b, k));
    }

    public static int kthElement(int a[], int b[], int k) {
        // code here
        int n = a.length + b.length;
        int res[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            res[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            res[i + a.length] = b[i];
        }
        Arrays.sort(res);
        return res[k - 1];
    }
}
