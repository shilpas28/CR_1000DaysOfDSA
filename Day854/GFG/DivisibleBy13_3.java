//GFG
//Divisible by 13
//Time complexity: O(N)
//Space complexity: O(1)

public class DivisibleBy13_3 {

    public static void main(String[] args) {
        String s = "2911285";
        System.out.println(divby13(s));
    }

    public static boolean divby13(String s) {
        // code here
        // Stores running remainder
        int rem = 0;
        // Process each digit and compute
        // remainder modulo 13
        for (int i = 0; i < s.length(); i++) {
            rem = (rem * 10 + (s.charAt(i) - '0')) % 13;
        }
        // Final check: if remainder is 0, number
        // is divisible by 13
        return rem == 0;
    }
}
