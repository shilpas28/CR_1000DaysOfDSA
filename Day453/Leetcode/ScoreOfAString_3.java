//Leetcode
//3110. Score of a String
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class ScoreOfAString_3 {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(scoreOfString(s));
    }

    public static int scoreOfString(String s) {
        return java.util.stream.IntStream.range(0, s.length() - 1).map(i -> Math.abs(s.charAt(i) - s.charAt(i + 1)))
                .sum();
    }
}
