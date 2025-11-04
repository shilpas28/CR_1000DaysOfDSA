//GFG
//Frog Jump - Space Optimization
//Time complexity: O(N)
//Space complexity: O(1)

public class FrogJump_3 {

    public static void main(String[] args) {
        int heights[] = { 20, 30, 40, 20 };
        System.out.println(minCost(heights));
    }

    static int minCost(int[] height) {
        // code here
        int n = height.length;
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {

            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = prev + Math.abs(height[i] - height[i - 1]);
            if (i > 1)
                jumpTwo = prev2 + Math.abs(height[i] - height[i - 2]);

            int cur_i = Math.min(jumpOne, jumpTwo);
            prev2 = prev;
            prev = cur_i;

        }
        return prev;
    }
}
