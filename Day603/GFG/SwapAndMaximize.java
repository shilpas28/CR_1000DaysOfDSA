//GFG
//Swap and Maximize
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class SwapAndMaximize {

    public static void main(String[] args) {
        Long arr[] = { 4l, 2l, 1l, 8l };
        System.out.println(maxSum(arr));
    }

    public static long maxSum(Long[] arr) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n / 2; ++i) {
            sum += 2 * arr[n - i - 1];
            sum -= 2 * arr[i];
        }
        return sum;
    }
}
