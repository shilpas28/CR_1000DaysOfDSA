//GFG
//Divisible by 13
//Time complexity: O(N)
//Space complexity: O(1)

import java.math.BigInteger;

public class DivisibleBy13 {

    public static void main(String[] args) {
        String s = "2911285";
        System.out.println(divby13(s));
    }

    public static boolean divby13(String s) {
        // code here
        BigInteger num = new BigInteger(s);
        return num.mod(BigInteger.valueOf(13)).equals(BigInteger.ZERO);
    }
}
