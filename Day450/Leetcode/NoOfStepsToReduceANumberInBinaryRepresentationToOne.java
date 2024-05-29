//Leetcode
//1404. Number of Steps to Reduce a Number in Binary Representation to One
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

import java.math.BigInteger;

public class NoOfStepsToReduceANumberInBinaryRepresentationToOne {

    public static void main(String[] args) {
        String s = "1101";
        System.out.println(numSteps(s));
    }

    public static int numSteps(String s) {
        BigInteger b = new BigInteger(s, 2);
        int steps = 0;
        while (!b.equals(BigInteger.ONE)) {
            if (b.testBit(0)) {
                b = b.add(BigInteger.ONE);
            } else {
                b = b.shiftRight(1);
            }
            steps++;
        }
        return steps;
    }
}
