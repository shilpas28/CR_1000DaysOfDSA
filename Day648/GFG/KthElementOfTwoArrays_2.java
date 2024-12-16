//GFG
//K-th element of two Arrays
//Time complexity: O(log(min(a, b)))
//Space complexity: O(1)

public class KthElementOfTwoArrays_2 {

    public static void main(String[] args) {
        int a[] = { 2, 3, 6, 7, 9 };
        int b[] = { 1, 4, 8, 10 };
        int k = 5;
        System.out.println(kthElement(a, b, k));
    }

    public static int kthElement(int a[], int b[], int k) {
        // code here
        int i = 0, j = 0, n = a.length, m = b.length, ans, c = 0;

        while (true) {
            int x1 = i < n ? a[i] : Integer.MAX_VALUE;
            int x2 = j < m ? b[j] : Integer.MAX_VALUE;

            if (x1 < x2) {
                i++;
                ans = x1;
            } else {
                j++;
                ans = x2;
            }
            c++;
            if (c == k)
                return ans;
        }
    }
}
