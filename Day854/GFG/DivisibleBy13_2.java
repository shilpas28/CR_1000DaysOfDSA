//GFG
//Divisible by 13
//Time complexity: O(N)
//Space complexity: O(1)

public class DivisibleBy13_2 {

    public static void main(String[] args) {
        String s = "2911285";
        System.out.println(divby13(s));
    }

    public static boolean divby13(String s) {
        // code here
        if (s == null || s.isEmpty()) {
            return false; // Or handle as an error, depending on requirements.
        }

        int remainder = 0;
        for (int i = 0; i < s.length(); i++) {
            char digitChar = s.charAt(i);
            int digit = digitChar - '0'; // Convert char digit to int
            remainder = (remainder * 10 + digit) % 13;
        }

        return remainder == 0;
    }
}
