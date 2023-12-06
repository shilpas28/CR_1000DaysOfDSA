//Leetcode
//1716. Calculate Money in Leetcode Bank - Math Approach 1
//Time complexity: O(1)
//Space complexity: O(1) 

package Leetcode;

public class CalculateMoneyInLeetcodeBank_2 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalMoney(n));
    }

    public static int totalMoney(int n) {
        int ans = 0;
        int weeks = n / 7; // Calculate the number of complete weeks
        int days = n % 7; // Calculate the remaining days
        // Calculate the total money earned from complete weeks
        // Using the formula for an arithmetic series: sum = n * (a1 + an) / 2
        ans += 28 * weeks + 7 * (weeks - 1) * weeks / 2; // 28 + 35 + 42 + ... + (28 + 7 * (weeks - 1))
        // Calculate the total money earned from remaining days
        // Starting from the next day after the last complete week
        int startMoney = weeks + 1; // Money earned on the first day of the remaining days
        ans += (startMoney + startMoney + days - 1) * days / 2; // a1 + an = (a1 + an) * n / 2
        return ans;
    }
}
