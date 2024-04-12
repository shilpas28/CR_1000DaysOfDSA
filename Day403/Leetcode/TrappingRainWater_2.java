//Leetcode - Better method
//42. Trapping Rain Water - similar to TrappingRainWater_2.java (Coding ninjas)
//Time complexity: O(3*N) as we are traversing through the array only once. And O(2*N) for computing prefix and suffix array. 
//Space complexity: O(N)+O(N) for prefix and suffix arrays.

package Leetcode;

public class TrappingRainWater_2 {

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int n = height.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }
        suffix[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(prefix[i], suffix[i]) - height[i];
        }
        return waterTrapped;
    }
}
