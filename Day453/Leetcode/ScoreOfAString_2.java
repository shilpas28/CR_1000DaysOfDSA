//Leetcode
//3110. Score of a String
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class ScoreOfAString_2 {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(scoreOfString(s));
    }

    public static int scoreOfString(String s) {
        int total = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            total += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return total;
    }
}
