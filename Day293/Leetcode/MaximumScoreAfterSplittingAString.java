//Leetcode
//1422. Maximum Score After Splitting a String
//Time complexity: O(N^2)
//Space complexity: O(1)  

package Leetcode;

public class MaximumScoreAfterSplittingAString {

    public static void main(String[] args) {
        String s = "011101";
        System.out.println(maxScore(s));
    }

    public static int maxScore(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int currentScore = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') {
                    currentScore++;
                }
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    currentScore++;
                }
            }
            result = Math.max(result, currentScore);
        }
        return result;
    }
}
