//Leetcode
//1014. Best Sightseeing Pair - Space Optimized DP
//Time complexity: O(N)
//Space complexity: O(1)

public class BestSightseeingPair_2 {

    public static void main(String[] args) {
        int[] values = { 8, 1, 5, 2, 6 };
        System.out.println(maxScoreSightseeingPair(values));
    }

    public static int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        // The left score is initially just the value of the first element.
        int maxLeftScore = values[0];
        int maxScore = 0;

        for (int i = 1; i < n; i++) {
            int currentRightScore = values[i] - i;
            // Update the maximum score by combining the best left score so far with the
            // current right score.
            maxScore = Math.max(maxScore, maxLeftScore + currentRightScore);
            int currentLeftScore = values[i] + i;
            // Update the maximum left score up to the current index.
            maxLeftScore = Math.max(maxLeftScore, currentLeftScore);
        }
        return maxScore;
    }
}
