//GFG
//Trapping Rain Water - Optimal Solution
//Time complexity: O(N) because we are using 2 pointer approach
//Space complexity: O(1) because we are not using anything extra

public class TrappingRainWater_3 {

    public static void main(String[] args) {
        int arr[] = { 3, 0, 1, 0, 4, 0, 2 };
        System.out.println(maxWater(arr));
    }

    public static int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int left = 0, right = n - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= maxLeft) {
                    maxLeft = arr[left];
                } else {
                    res += maxLeft - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= maxRight) {
                    maxRight = arr[right];
                } else {
                    res += maxRight - arr[right];
                }
                right--;
            }
        }
        return res;
    }
}
