//Leetcode
//1404. Number of Steps to Reduce a Number in Binary Representation to One
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class NoOfStepsToReduceANumberInBinaryRepresentationToOne_2 {

    public static void main(String[] args) {
        String s = "1101";
        System.out.println(numSteps(s));
    }

    public static int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                steps += 2;
            } else {
                steps += 1;
            }
        }
        return steps + carry;
    }
}
