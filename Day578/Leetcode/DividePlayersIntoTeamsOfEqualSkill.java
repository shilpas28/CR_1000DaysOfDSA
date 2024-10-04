//Leetcode
//2491. Divide Players Into Teams of Equal Skill
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class DividePlayersIntoTeamsOfEqualSkill {

    public static void main(String[] args) {
        int[] skill = { 3, 2, 5, 1, 3, 4 };
        System.out.println(dividePlayers(skill));
    }

    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int lo = 0, hi = skill.length - 1;

        int sum = skill[lo] + skill[hi];
        long prod = (long) skill[lo] * skill[hi];

        lo++;
        hi--;

        while (lo < hi) {
            if (skill[hi] + skill[lo] != sum)
                return -1;
            else {
                prod += (long) skill[lo] * skill[hi];
                lo++;
                hi--;
            }
        }
        return prod;
    }
}
