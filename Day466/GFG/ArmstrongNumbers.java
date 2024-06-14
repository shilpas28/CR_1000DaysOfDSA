//GFG
//Armstrong Numbers
//Time complexity: O(1)
//Space complexity: O(1)

package GFG;

public class ArmstrongNumbers {

    public static void main(String[] args) {
        int n = 153;
        System.out.println(armstrongNumber(n));
    }

    static String armstrongNumber(int n) {
        // code here
        int num = 0, temp = n;
        while (temp != 0) {
            int digit = temp % 10;
            num += digit * digit * digit;
            temp /= 10;
        }
        return num == n ? "true" : "false";
    }
}
