//Leetcode
//2140. Solving Questions With Brainpower - Iterative
//Time complexity: O(N)
//Space complexity: O(N) 

public class SolvingQuestionsWithBrainpower_2 {

    public static void main(String[] args) {
        int[][] questions = { { 3, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } };
        System.out.println(mostPoints(questions));
    }

    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            int points = questions[i][0], jump = questions[i][1];
            dp[i] = Math.max(points + dp[Math.min(jump + i + 1, n)], dp[i + 1]);
        }
        return dp[0];
    }
}
