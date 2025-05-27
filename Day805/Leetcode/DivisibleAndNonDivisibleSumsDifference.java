//Leetcode
//2894. Divisible and Non-divisible Sums Difference - Brute Force 
//Time complexity: O(N)
//Space complexity: O(1)

public class DivisibleAndNonDivisibleSumsDifference {

    public static void main(String[] args) {
        int n = 10, m = 3;
        System.out.println(differenceOfSums(n, m));
    }

    public static int differenceOfSums(int n, int m) {
        int num1 = 0, num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0)
                num2 += i;
            else
                num1 += i;
        }
        return num1 - num2;
    }
}
