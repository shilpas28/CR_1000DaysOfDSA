//Leetcode
//1716. Calculate Money in Leetcode Bank - Math Approach 2
//Time complexity: O(1)
//Space complexity: O(1)

package Leetcode;

public class CalculateMoneyInLeetcodeBank_3 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalMoney(n));
    }

    public static int totalMoney(int n) {
        int k = n / 7;
        int F = 28;
        int L = 28 + (k - 1) * 7;
        int arithmeticSum = k * (F + L) / 2;

        int monday = 1 + k;
        int finalWeek = 0;
        for (int day = 0; day < n % 7; day++) {
            finalWeek += monday + day;
        }

        return arithmeticSum + finalWeek;
    }
}
