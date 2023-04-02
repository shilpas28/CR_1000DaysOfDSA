//Leetcode - Binary Search without Inbuilt Libraries 
//2300. Successful Pairs of Spells and Potions
//Time complexity: O(mlogm + mlogn)
//Space complexity: O(N)

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions_1 {

    public static void main(String[] args) {
        int[] spells = { 5, 1, 3 };
        int[] potions = { 1, 2, 3, 4, 5 };
        long success = 7;
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            res[i] = potions.length - valid_pos(potions, success, spells[i]);
        }
        return res;
    }

    public static int valid_pos(int[] potions, long success, int spell) {
        long potion_needed = (success + spell - 1) / spell;
        int l = 0, r = potions.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (potions[mid] >= potion_needed)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
