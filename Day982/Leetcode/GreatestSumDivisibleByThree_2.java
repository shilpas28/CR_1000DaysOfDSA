//Leetcode
//1262. Greatest Sum Divisible by Three - Greedy + Backward Thinking
//Time complexity: O(nlogn)
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class GreatestSumDivisibleByThree_2 {

    public static void main(String[] args) {
        int[] nums = {3, 6, 5, 1, 8};
        System.out.println(maxSumDivThree(nums));
    }

    public static int maxSumDivThree(int[] nums) {
        // Use v[0], v[1], v[2] to represent a, b, c respectively.
        List<Integer>[] v = new List[3];
        for (int i = 0; i < 3; ++i) {
            v[i] = new ArrayList<>();
        }
        for (int num : nums) {
            v[num % 3].add(num);
        }
        Collections.sort(v[1], (a, b) -> b - a);
        Collections.sort(v[2], (a, b) -> b - a);

        int tot = Arrays.stream(nums).sum();
        int remove = Integer.MAX_VALUE;

        if (tot % 3 == 0) {
            remove = 0;
        } else if (tot % 3 == 1) {
            if (v[1].size() >= 1) {
                remove = Math.min(remove, v[1].get(v[1].size() - 1));
            }
            if (v[2].size() >= 2) {
                remove = Math.min(
                        remove,
                        v[2].get(v[2].size() - 2) + v[2].get(v[2].size() - 1)
                );
            }
        } else {
            if (v[1].size() >= 2) {
                remove = Math.min(
                        remove,
                        v[1].get(v[1].size() - 2) + v[1].get(v[1].size() - 1)
                );
            }
            if (v[2].size() >= 1) {
                remove = Math.min(remove, v[2].get(v[2].size() - 1));
            }
        }

        return tot - remove;
    }
}
