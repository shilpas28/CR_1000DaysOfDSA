//Leetcode
//1262. Greatest Sum Divisible by Three - Greedy + Forward Thinking
//Time complexity: O(nlogn)
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class GreatestSumDivisibleByThree {

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

        int ans = 0;
        int lb = v[1].size();
        int lc = v[2].size();
        for (int cntb = lb - 2; cntb <= lb; ++cntb) {
            if (cntb >= 0) {
                for (int cntc = lc - 2; cntc <= lc; ++cntc) {
                    if (cntc >= 0 && (cntb - cntc) % 3 == 0) {
                        ans = Math.max(
                                ans,
                                getSum(v[1], 0, cntb) + getSum(v[2], 0, cntc)
                        );
                    }
                }
            }
        }
        return ans + getSum(v[0], 0, v[0].size());
    }

    public static int getSum(List<Integer> list, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; ++i) {
            sum += list.get(i);
        }
        return sum;
    }
}
