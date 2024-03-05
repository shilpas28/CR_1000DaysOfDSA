//GFG
//Maximum Index
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class MaximumIndex {

    public static void main(String[] args) {
        int n = 9;
        int a[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
        System.out.println(maxIndexDiff(a, n));
    }

    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) {

        // Your code here
        if (n == 1)
            return 0;
        int leftMin[] = new int[n];
        int rightMax[] = new int[n];

        leftMin[0] = a[0];
        for (int i = 1; i < n; ++i)
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);

        rightMax[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], a[i]);

        int i = 0, j = 0, ans = -1;
        while (i < n && j < n) {
            if (leftMin[i] > rightMax[j])
                ++i;
            else {
                ans = Math.max(ans, j - i);
                ++j;
            }
        }
        return ans;
    }
}
