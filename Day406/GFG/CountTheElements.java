//GFG
//Count the elements
//Time complexity: O(n+q+maximum of a and b)
//Space complexity: O(maximum of a and b)

package GFG;

import java.util.Arrays;

public class CountTheElements {

    public static void main(String[] args) {
        int n = 4;
        int a[] = { 1, 1, 5, 5 };
        int b[] = { 0, 1, 2, 3 };
        int q = 4;
        int query[] = { 0, 1, 2, 3 };
        System.out.println(Arrays.toString(countElements(a, b, n, query, q)));
    }

    public static int[] countElements(int a[], int b[], int n, int query[], int q) {
        int mx = -1;
        for (int i = 0; i < n; i++)
            mx = Math.max(mx, b[i]);
        int heap[] = new int[mx + 1];
        Arrays.fill(heap, 0);
        for (int i = 0; i < n; i++)
            heap[b[i]]++;
        for (int i = 1; i <= mx; i++)
            heap[i] += heap[i - 1];
        int ans[] = new int[q];
        for (int i = 0; i < q; i++) {
            if (a[query[i]] > mx) {
                ans[i] = n;
            } else
                ans[i] = heap[a[query[i]]];
        }
        return ans;
    }
}
