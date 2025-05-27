//Leetcode
//2894. Divisible and Non-divisible Sums Difference - Using Math
//Time complexity: O(1)
//Space complexity: O(1)

public class DivisibleAndNonDivisibleSumsDifference_2 {

    public static void main(String[] args) {
        int n = 10, m = 3;
        System.out.println(differenceOfSums(n, m));
    }

    public static int differenceOfSums(int n, int m) {
        int totalSum = n * (n + 1) / 2;
        int divisibleSum = m * (n / m) * (n / m + 1);
        return totalSum - divisibleSum;
    }
}
