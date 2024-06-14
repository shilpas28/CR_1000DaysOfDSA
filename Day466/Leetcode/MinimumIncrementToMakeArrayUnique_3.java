//Leetcode
//945. Minimum Increment to Make Array Unique - Union Find
//Time complexity: Amortized O(N)
//Space complexity: O(N)

import java.util.HashMap;

public class MinimumIncrementToMakeArrayUnique_3 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 2, 1, 7 };
        System.out.println(minIncrementForUnique(nums));
    }

    static HashMap<Integer, Integer> root;

    public static int minIncrementForUnique(int[] nums) {
        root = new HashMap<>();
        int res = 0;
        for (int a : nums)
            res += find(a) - a;
        return res;
    }

    static int find(int x) {
        if (root.containsKey(x))
            root.put(x, find(root.get(x) + 1));
        else
            root.put(x, x);
        return root.get(x);
    }
}
