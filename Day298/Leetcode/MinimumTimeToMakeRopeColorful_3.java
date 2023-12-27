//Leetcode
//1578. Minimum Time to Make Rope Colorful - Space Optimization
//Time complexity: O(n)
//Space complexity: O(1)  

package Leetcode;

public class MinimumTimeToMakeRopeColorful_3 {

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = { 1, 2, 3, 4, 5 };
        System.out.println(minCost(colors, neededTime));
    }

    public static int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        char previousColor = 'A';
        int previousTime = 0;
        int currentCost = 0, previousCost = 0;

        for (int i = 1; i <= n; i++) {
            if (colors.charAt(i - 1) == previousColor) {
                currentCost = previousCost + Math.min(neededTime[i - 1], previousTime);
                previousTime = Math.max(neededTime[i - 1], previousTime);
            } else {
                currentCost = previousCost;
                previousColor = colors.charAt(i - 1);
                previousTime = neededTime[i - 1];
            }
            previousCost = currentCost;
        }

        return previousCost;
    }
}
