//GFG
//Implement Atoi
//Time complexity: O(|s|)
//Space complexity: O(1)

public class ImplementAtoi {

    public static void main(String[] args) {
        String s = "-123";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        // Your code here
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == ' ') {
            ++i;
        }

        int sign = 1;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            ++i;
        }

        long res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            res = res * 10 + s.charAt(i) - '0';
            if (res * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (res * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            ++i;
        }

        return (int) (res * sign);
    }
}
