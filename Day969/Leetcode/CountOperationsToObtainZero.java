//Leetcode
//2169. Count Operations to Obtain Zero - Iterative Subtraction (Brute Force)
//Time complexity: O(log(min(num1, num2)))
//Space complexity: O(1) 

public class CountOperationsToObtainZero {

    public static void main(String[] args) {
        int num1 = 2, num2 = 3;
        System.out.println(countOperations(num1, num2));
    }

    public static int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
            count++;
        }
        return count;
    }
}
