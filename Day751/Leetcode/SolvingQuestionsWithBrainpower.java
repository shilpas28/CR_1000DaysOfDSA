//Leetcode
//2140. Solving Questions With Brainpower - DFS with Memoization
//Time complexity: O(N)
//Space complexity: O(N) 

public class SolvingQuestionsWithBrainpower {

    public static void main(String[] args) {
        int[][] questions = { { 3, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } };
        System.out.println(mostPoints(questions));
    }

    static long dp[];

    public static long mostPoints(int[][] questions) {
        dp = new long[questions.length];
        return dfs(questions, 0);
    }

    static long dfs(int[][] Q, int i) {
        if (i >= Q.length)
            return 0;
        if (dp[i] > 0)
            return dp[i];
        int points = Q[i][0], jump = Q[i][1];
        return dp[i] = Math.max(dfs(Q, i + 1), points + dfs(Q, i + jump + 1));
    }
}
