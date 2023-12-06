//Leetcode
//1716. Calculate Money in Leetcode Bank - Simulate
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class CalculateMoneyInLeetcodeBank {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalMoney(n));
    }

    public static int totalMoney(int n) {
        int ans = 0;
        int monday = 1;

        while (n > 0) {
            for (int day = 0; day < Math.min(n, 7); day++) {
                ans += monday + day;
            }
            n -= 7;
            monday++;
        }
        return ans;
    }
}
