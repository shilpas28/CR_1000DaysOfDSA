//Leetcode
//3147. Taking Maximum Energy From the Mystic Dungeon
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class TakingMaximumEnergyFromTheMysticDungeon_3 {

    public static void main(String[] args) {
        int[] energy = { 5, 2, -10, -5, 1 };
        int k = 3;
        System.out.println(maximumEnergy(energy, k));
    }

    public static int maximumEnergy(int[] energy, int k) {
        for (int i = energy.length - k - 1; i >= 0; i--)
            energy[i] += energy[i + k];
        return Arrays.stream(energy).max().getAsInt();
    }
}
