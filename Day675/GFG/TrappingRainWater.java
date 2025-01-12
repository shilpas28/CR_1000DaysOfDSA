//GFG
//Trapping Rain Water - Brute Force - Not accepted as TLE
//Time complexity: O(N*N) as for each index we are calculating leftMax and rightMax so it is a nested loop
//Space complexity: O(1)

public class TrappingRainWater {

    public static void main(String[] args) {
        int arr[] = { 3, 0, 1, 0, 4, 0, 2 };
        System.out.println(maxWater(arr));
    }

    public static int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int leftMax = 0, rightMax = 0;
            while (j >= 0) {
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }
            j = i;
            while (j < n) {
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }
            waterTrapped += Math.min(leftMax, rightMax) - arr[i];
        }
        return waterTrapped;
    }
}
