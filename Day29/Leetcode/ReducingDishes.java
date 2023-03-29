//Leetcode - using Recursion (doesnt accept it as TLE)
//1402. Reducing Dishes
//Time complexity:
//Space complexity:

import java.util.Arrays;

public class ReducingDishes {

    public static void main(String[] args) {
        int[] satisfaction = { -1, -8, 0, 5, -9 };
        System.out.println(maxSatisfaction(satisfaction));
    }

    public static int maxSatisfaction(int[] satisfaction) {
        // sort
        Arrays.sort(satisfaction);
        return solve(satisfaction, 0, 0);
    }

    static int solve(int[] satisfaction, int index, int time) {
        // base case
        if (index == satisfaction.length)
            return 0;

        int include = satisfaction[index] * (time + 1) + solve(satisfaction, index + 1, time + 1);
        int exclude = 0 + solve(satisfaction, index + 1, time);
        return Math.max(include, exclude);
    }
}
