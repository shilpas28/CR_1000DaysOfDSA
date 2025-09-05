//Leetcode
//2749. Minimum Operations to Make the Integer Zero
//Time complexity: O(log num1)
//Space complexity: O(1)

public class MinimumOperationsToMakeTheIntegerZero {

    public static void main(String[] args) {
        int num1 = 3, num2 = -2;
        System.out.println(makeTheIntegerZero(num1, num2));
    }

    public static int makeTheIntegerZero(int num1, int num2) {
        int k = 1;
        while (true) {
            long x = num1 - (long) num2 * k;
            if (x < k) {
                return -1;
            }
            if (k >= Long.bitCount(x)) {
                return k;
            }
            k++;
        }
    }
}
