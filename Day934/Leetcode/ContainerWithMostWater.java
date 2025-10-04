//Leetcode
//11. Container With Most Water - Using 2 pointer approach
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int start_pointer = 0;
        int end_pointer = height.length - 1;
        int maxArea = 0;
        while (start_pointer < end_pointer) {
            if (height[start_pointer] < height[end_pointer]) {
                maxArea = Math.max(maxArea, height[start_pointer] * (end_pointer - start_pointer));
                start_pointer++;
            } else {
                maxArea = Math.max(maxArea, height[end_pointer] * (end_pointer - start_pointer));
                end_pointer--;
            }
        }
        return maxArea;
    }
}
