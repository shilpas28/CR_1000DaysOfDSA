//Leetcode - Space optimization solution - Debug this code(it's not working currently)
//1402. Reducing Dishes
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.Arrays;

public class ReducingDishes_3 {

    public static void main(String[] args) {
        int[] satisfaction = { -1, -8, 0, 5, -9 };
        System.out.println(maxSatisfaction(satisfaction));
    }

    public static int maxSatisfaction(int[] satisfaction) {
        // sort
        Arrays.sort(satisfaction);
        return solve(satisfaction);
    }

    static int solve(int[] satisfaction) {
        // base case
        int n = satisfaction.length;
        int[] curr = new int[n + 1];
        int[] next = new int[n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int time = index; time >= 0; time--) {

                int include = satisfaction[index] * (time + 1) + next[time + 1];
                int exclude = 0 + next[time];

                curr[time] = Math.max(include, exclude);
            }
            next = curr;
        }
        return next[0];
    }
}
