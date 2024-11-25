//GFG
//Maximum Product Subarray
//Time complexity: O(N)
//Space complexity: O(1)

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int arr[] = { -2, 6, -3, -10, 0, 2 };
        System.out.println(maxProduct(arr));
    }

    // Function to find maximum product subarray
    static int maxProduct(int[] arr) {
        // code here
        int ans = Integer.MIN_VALUE, productStart = 1, productEnd = 1, n = arr.length;
        for (int i = 0; i < n; i++) {
            productStart *= arr[i];
            productEnd *= arr[n - 1 - i];
            ans = Math.max(ans, Math.max(productStart, productEnd));
            if (productStart == 0)
                productStart = 1;
            if (productEnd == 0)
                productEnd = 1;
        }
        return ans;
    }
}
