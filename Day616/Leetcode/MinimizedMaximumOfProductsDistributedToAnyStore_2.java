//Leetcode
//2064. Minimized Maximum of Products Distributed to Any Store - Greedy Binary Search
//Time complexity: O(n * log m)
//Space complexity: O(1)

package Leetcode;

public class MinimizedMaximumOfProductsDistributedToAnyStore_2 {

    public static void main(String[] args) {
        int n = 6;
        int[] quantities = { 11, 6 };
        System.out.println(minimizedMaximum(n, quantities));
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int maxQuantity = 0;
        for (int quantity : quantities) {
            maxQuantity = Math.max(maxQuantity, quantity);
        }

        int left = 1;
        int right = maxQuantity;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistributeProducts(mid, n, quantities)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    static boolean canDistributeProducts(int maxProductsPerStore, int storeCount, int[] quantities) {
        int requiredStores = 0;
        for (int quantity : quantities) {
            // Calculate stores needed for current product type
            requiredStores += (quantity + maxProductsPerStore - 1) / maxProductsPerStore;
        }
        return requiredStores <= storeCount;
    }
}
