//Leetcode
//3147. Taking Maximum Energy From the Mystic Dungeon
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class TakingMaximumEnergyFromTheMysticDungeon {

    public static void main(String[] args) {
        int[] energy = { 5, 2, -10, -5, 1 };
        int k = 3;
        System.out.println(maximumEnergy(energy, k));
    }

    public static int maximumEnergy(int[] energy, int k) {
        int len = energy.length;
        int arr[] = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (i + k < len) {
                arr[i] = energy[i] + arr[i + k];
            } else {
                arr[i] = energy[i];
            }
        }
        Arrays.sort(arr);
        return arr[len - 1];
    }
}
