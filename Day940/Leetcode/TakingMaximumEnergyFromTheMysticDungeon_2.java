//Leetcode
//3147. Taking Maximum Energy From the Mystic Dungeon
//Time complexity: O(N)
//Space complexity: O(N)

public class TakingMaximumEnergyFromTheMysticDungeon_2 {

    public static void main(String[] args) {
        int[] energy = { 5, 2, -10, -5, 1 };
        int k = 3;
        System.out.println(maximumEnergy(energy, k));
    }

    public static int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];

        int res = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = energy[i] + (i + k < n ? dp[i + k] : 0);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
