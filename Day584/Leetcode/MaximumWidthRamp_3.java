//Leetcode
//962. Maximum Width Ramp - Stack
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Stack;

public class MaximumWidthRamp_3 {

    public static void main(String[] args) {
        int[] nums = { 6, 0, 8, 2, 1, 5 };
        System.out.println(maxWidthRamp(nums));
    }

    public static int maxWidthRamp(int[] nums) {
        // scanning from left to right to get all possible indices of the min element
        // seen so far
        // think a bit and you'll discover they are valid START INDICES candidates for
        // the widest ramp
        // they are [i0, i1, i2, i3, i4] as in the pic attached, you could use the pic
        // to think on the algorithm
        int N = nums.length;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (s.isEmpty() || nums[i] < nums[s.peek()]) {
                s.push(i);
            }
        }
        // now scanning backwards for all other non-min elements, let them pair with all
        // the candidates
        // we've collected in the first step in stack. Meanwhile, if we've discover that
        // the current index i could
        // form a ramp with a min idx j, we know j couldn't form a better solution since
        // i is going backwards
        // so we pop j out of stack
        int res = 0;
        for (int i = N - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                res = Math.max(res, i - s.pop());
            }
        }
        return res;
    }
}
