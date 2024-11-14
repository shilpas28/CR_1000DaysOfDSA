//Leetcode
//2064. Minimized Maximum of Products Distributed to Any Store - Simple Binary Search
//Time complexity: O(m * log k)
//Space complexity: O(1)

package Leetcode;

public class MinimizedMaximumOfProductsDistributedToAnyStore {

    public static void main(String[] args) {
        int n = 6;
        int[] quantities = { 11, 6 };
        System.out.println(minimizedMaximum(n, quantities));
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int res = 0;
        int left = 1;
        int right = getMax(quantities);

        while (left <= right) {
            int x = (left + right) / 2;
            if (canDistribute(x, n, quantities)) {
                res = x;
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return res;
    }

    static boolean canDistribute(int x, int n, int[] quantities) {
        int stores = 0;
        for (int q : quantities) {
            stores += (q + x - 1) / x;
        }
        return stores <= n;
    }

    static int getMax(int[] quantities) {
        int max = quantities[0];
        for (int q : quantities) {
            max = Math.max(max, q);
        }
        return max;
    }
}
