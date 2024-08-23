//Leetcode
//592. Fraction Addition and Subtraction
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.stream.Stream;

public class FractionAdditionAndSubtraction {

    public static void main(String[] args) {
        String expression = "-1/2+1/2+1/3";
        System.out.println(fractionAddition(expression));
    }

    public static String fractionAddition(String expression) {
        String[] fracs = expression.split("(?=[-+])"); // splits input string into individual fractions
        String res = "0/1";
        for (String frac : fracs)
            res = add(res, frac); // add all fractions together
        return res;
    }

    public static String add(String frac1, String frac2) {
        int[] f1 = Stream.of(frac1.split("/")).mapToInt(Integer::parseInt).toArray(),
                f2 = Stream.of(frac2.split("/")).mapToInt(Integer::parseInt).toArray();
        int numer = f1[0] * f2[1] + f1[1] * f2[0], denom = f1[1] * f2[1];
        String sign = "";
        if (numer < 0) {
            sign = "-";
            numer *= -1;
        }
        return sign + numer / gcd(numer, denom) + "/" + denom / gcd(numer, denom); // construct reduced fraction
    }

    // Computes gcd using Euclidean algorithm
    public static int gcd(int x, int y) {
        return x == 0 || y == 0 ? x + y : gcd(y, x % y);
    }
}
