//Leetcode
//1769. Minimum Number of Operations to Move All Balls to Each Box - Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1)

import java.util.Arrays;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    public static void main(String[] args) {
        String boxes = "110";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }

    public static int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        for (int currentBox = 0; currentBox < boxes.length(); currentBox++) {
            // If the current box contains a ball, calculate the number of moves for every
            // box.
            if (boxes.charAt(currentBox) == '1') {
                for (int newPosition = 0; newPosition < boxes.length(); newPosition++) {
                    answer[newPosition] += Math.abs(newPosition - currentBox);
                }
            }
        }
        return answer;
    }
}
