//Leetcode
//1323. Maximum 69 Number - Digit Manipulation 
//Time complexity: O(digit)
//Space complexity: O(1)

public class Maximum69Number_3 {

    public static void main(String[] args) {
        int num = 9669;
        System.out.println(maximum69Number(num));
    }

    public static int maximum69Number(int num) {
        int n = num;
        int i = 1;
        int rev = 0;

        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
            i *= 10;
        }

        while (rev % 10 == 9) {
            rev /= 10;
            i /= 10;
        }

        return num + 3 * (i / 10);
    }
}
