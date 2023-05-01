//Leetcode - better method in terms of time complexity
//1491. Average Salary Excluding the Minimum and Maximum Salary
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class AverageSalaryExcludingMinimumAndMaximumSalary_2 {
    public static void main(String[] args) {
        int[] salary = { 4000, 3000, 1000, 2000 };
        System.out.println(average(salary));
    }

    public static double average(int[] salary) {
        double sum = 0.0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
        }
        sum -= (min + max);
        return sum / (salary.length - 2);
    }
}
