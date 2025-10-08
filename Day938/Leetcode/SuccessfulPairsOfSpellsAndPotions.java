//Leetcode
//2300. Successful Pairs of Spells and Potions
//Time complexity: O(mlogm + mlogn)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;
import java.util.TreeMap;

public class SuccessfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {
        int[] spells = { 5, 1, 3 };
        int[] potions = { 1, 2, 3, 4, 5 };
        long success = 7;
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(Long.MAX_VALUE, potions.length);
        for (int i = potions.length - 1; i >= 0; i--) {
            map.put((long) potions[i], i);
        }
        for (int i = 0; i < spells.length; i++) {
            long need = (success + spells[i] - 1) / spells[i];
            spells[i] = potions.length - map.ceilingEntry(need).getValue();
        }
        return spells;
    }
}
