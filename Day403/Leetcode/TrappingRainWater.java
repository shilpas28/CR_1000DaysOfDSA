//Leetcode - Brute force method
//42. Trapping Rain Water - similar to TrappingRainWater.java (Coding ninjas)
//Time complexity: O(N*N) as for each index we are calculating leftMax and rightMax so it is a nested loop.
//Space complexity: O(1).

package Leetcode;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int n = height.length;
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int leftMax = 0, rightMax = 0;
            while (j >= 0) {
                leftMax = Math.max(leftMax, height[j]);
                j--;
            }
            j = i;
            while (j < n) {
                rightMax = Math.max(rightMax, height[j]);
                j++;
            }
            waterTrapped += Math.min(leftMax, rightMax) - height[i];
        }
        return waterTrapped;
    }
}
