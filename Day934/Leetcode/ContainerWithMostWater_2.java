//Leetcode
//11. Container With Most Water - Using 2 pointer approach (almost same as previous, but area calculated only once)
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class ContainerWithMostWater_2 {

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int start_pointer = 0;
        int end_pointer = height.length - 1;
        while (start_pointer <= end_pointer) {
            maxArea = Math.max(Math.min(height[start_pointer], height[end_pointer]) * (end_pointer - start_pointer),
                    maxArea);
            if (height[start_pointer] < height[end_pointer]) {
                start_pointer++;
            } else {
                end_pointer--;
            }
        }
        return maxArea;
    }
}
