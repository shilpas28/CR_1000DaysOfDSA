//Leetcode
//3494. Find the Minimum Amount of Time to Brew Potions
//Time complexity: O(n*m)
//Space complexity: O(n)

public class FindTheMinimumAmountOfTimeToBrewPotions {

    public static void main(String[] args) {
        int[] skill = { 1, 5, 2, 4 };
        int[] mana = { 5, 1, 4, 2 };
        System.out.println(minTime(skill, mana));
    }

    public static long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] done = new long[n + 1];

        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                done[i + 1] = Math.max(done[i + 1], done[i]) + (long) mana[j] * skill[i];
            }
            for (int i = n - 1; i > 0; --i) {
                done[i] = done[i + 1] - (long) mana[j] * skill[i];
            }
        }

        return done[n];
    }
}
