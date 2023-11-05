//Leetcode
//1535. Find the Winner of an Array Game
//Time complexity: O(N) - The solution iterates through the array once. In the worst-case scenario, we examine all elements 
//in the array. Hence, the time complexity is linear with respect to the size of the array.
//Space complexity: O(1) - The solution uses a constant amount of extra space: a few variables to keep track of the current 
//winner and the consecutive win count. Regardless of the size of the input, the space used remains constant.

package Leetcode;

import java.util.Arrays;

public class FindTheWinnerOfAnArrayGame {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 5, 4, 6, 7 };
        int k = 2;
        System.out.println(getWinner(arr, k));
    }

    public static int getWinner(int[] arr, int k) {
        if (k == 1) {
            return Math.max(arr[0], arr[1]);
        }
        if (k >= arr.length) {
            return Arrays.stream(arr).max().getAsInt();
        }

        int current_winner = arr[0];
        int consecutive_wins = 0;

        for (int i = 1; i < arr.length; i++) {
            if (current_winner > arr[i]) {
                consecutive_wins++;
            } else {
                current_winner = arr[i];
                consecutive_wins = 1;
            }

            if (consecutive_wins == k) {
                return current_winner;
            }
        }

        return current_winner;
    }
}
