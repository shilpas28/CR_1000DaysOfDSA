//Leetcode
//1769. Minimum Number of Operations to Move All Balls to Each Box - Sum of Left and Right Moves
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox_2 {

    public static void main(String[] args) {
        String boxes = "110";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }

    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        int ballsToLeft = 0, movesToLeft = 0;
        int ballsToRight = 0, movesToRight = 0;

        // Single pass: calculate moves from both left and right
        for (int i = 0; i < n; i++) {
            // Left pass
            answer[i] += movesToLeft;
            ballsToLeft += Character.getNumericValue(boxes.charAt(i));
            movesToLeft += ballsToLeft;
            // Right pass
            int j = n - 1 - i;
            answer[j] += movesToRight;
            ballsToRight += Character.getNumericValue(boxes.charAt(j));
            movesToRight += ballsToRight;
        }
        return answer;
    }
}
