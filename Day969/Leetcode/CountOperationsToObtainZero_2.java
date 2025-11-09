//Leetcode
//2169. Count Operations to Obtain Zero - Recursive Subtraction
//Time complexity: O(log(min(num1, num2)))
//Space complexity: O(log(min(num1, num2)))

public class CountOperationsToObtainZero_2 {

    public static void main(String[] args) {
        int num1 = 2, num2 = 3;
        System.out.println(countOperations(num1, num2));
    }

    public static int countOperations(int num1, int num2) {
        return findCount(num1, num2, 0);
    }

    public static int findCount(int num1, int num2, int count) {
        if (num1 == 0 || num2 == 0)
            return count;
        if (num1 > num2)
            return findCount(num1 - num2, num2, count + 1);
        return findCount(num1, num2 - num1, count + 1);
    }
}
