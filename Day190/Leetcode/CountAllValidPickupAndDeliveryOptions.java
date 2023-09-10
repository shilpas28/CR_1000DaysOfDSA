//Leetcode
//1359. Count All Valid Pickup and Delivery Options
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class CountAllValidPickupAndDeliveryOptions {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(countOrders(n));
    }

    public static int countOrders(int n) {
        long res = 1, mod = 1000000007;
        for (int i = 1; i <= n; ++i) {
            res *= i;
            res %= mod;
            res *= (2 * i - 1);
            res %= mod;
        }
        return (int) (res % mod);
    }
}
