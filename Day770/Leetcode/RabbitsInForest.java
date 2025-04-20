//Leetcode
//781. Rabbits in Forest
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {

    public static void main(String[] args) {
        int[] answers = { 1, 1, 2 };
        System.out.println(numRabbits(answers));
    }

    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i : answers)
            mpp.put(i, mpp.getOrDefault(i, 0) + 1);

        int total = 0;
        for (Map.Entry<Integer, Integer> p : mpp.entrySet())
            total += Math.ceil((double) p.getValue() / (p.getKey() + 1)) * (p.getKey() + 1);

        return total;
    }
}
