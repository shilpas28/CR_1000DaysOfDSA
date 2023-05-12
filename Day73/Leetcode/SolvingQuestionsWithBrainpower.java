//Leetcode
//2140. Solving Questions With Brainpower
//Time complexity: O(N) 
//Space complexity: O(N) 

package Leetcode;

import java.util.Arrays;

public class SolvingQuestionsWithBrainpower {

    public static void main(String[] args) {
        int[][] questions = { { 3, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } };
        System.out.println(mostPoints(questions));
    }

    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, 0);
        for (int i = n - 1; i >= 0; i--) {
            int point = questions[i][0];
            int jump = questions[i][1];
            int nextQuestion = Math.min(n, i + jump + 1);
            dp[i] = Math.max(dp[i + 1], point + dp[nextQuestion]);
        }
        return dp[0];
    }
}
