//GFG
//Stickler Thief II
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.Arrays;

public class SticklerThiefII {

    public static void main(String[] args) {
        int arr[] = { 2, 3, 2 };
        System.out.println(maxValue(arr));
    }

    static int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return arr[0];

        return Math.max(robLinear(Arrays.copyOfRange(arr, 1, n)), robLinear(Arrays.copyOfRange(arr, 0, n - 1)));
    }

    static int robLinear(int[] nums) {
        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int temp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }

}
