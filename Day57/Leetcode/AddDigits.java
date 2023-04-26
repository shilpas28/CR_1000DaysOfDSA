//Leetcode
//Add Digits
//Time complexity: O(no:of digits)
//Space complexity: O(1)

package Leetcode;

public class AddDigits {

    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }

    public static int addDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum = sum + rem;
            num = num / 10;

            if (num == 0 && sum > 9) {
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }

}
