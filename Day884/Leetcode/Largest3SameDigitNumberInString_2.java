//Leetcode
//2264. Largest 3-Same-Digit Number in String
//Time complexity: O(n), where n is the length of the input string num. The algorithm iterates through the string once.
//Space complexity: O(1), as the space used is independent of the input size. The algorithm uses a constant amount of space 
//for variables regardless of the input size.

package Leetcode;

public class Largest3SameDigitNumberInString_2 {

    public static void main(String[] args) {
        String num = "6777133339";
        System.out.println(largestGoodInteger(num));
    }

    public static String largestGoodInteger(String num) {
        String ans = "";
        for (int i = 2; i < num.length(); i++)
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i - 1) == num.charAt(i - 2))
                if (num.substring(i - 2, i + 1).compareTo(ans) > 0) // Check if the new one is larger
                    ans = num.substring(i - 2, i + 1);
        return ans;
    }
}
