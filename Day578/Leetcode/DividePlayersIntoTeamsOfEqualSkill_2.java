//Leetcode
//2491. Divide Players Into Teams of Equal Skill
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class DividePlayersIntoTeamsOfEqualSkill_2 {

    public static void main(String[] args) {
        int[] skill = { 3, 2, 5, 1, 3, 4 };
        System.out.println(dividePlayers(skill));
    }

    public static long dividePlayers(int[] skill) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int n = skill.length;

        for (int num : skill) {
            sum += num;
            map.put(num, (map.getOrDefault(num, 0) + 1));
        }

        // checking whether we can divide sum into n/2 pairs,
        if (sum % (n / 2) != 0)
            return -1;
        int div = sum / (n / 2); // 6 for [3,2,5,1,3,4]

        long prod = 0;
        for (int i = 0; i < n; i++) {
            int num = skill[i];
            // div-num i.e. our target for each num,
            // either is not present in map, or has been used in previous iterations
            if (!map.containsKey(div - num) || map.get(div - num) <= 0)
                return -1;

            map.put(div - num, map.get(div - num) - 1);
            prod += (long) (num * (div - num));
        }
        return prod / 2;
    }
}
