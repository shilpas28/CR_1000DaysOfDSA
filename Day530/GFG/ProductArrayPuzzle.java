//GFG
//Product array puzzle
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class ProductArrayPuzzle {

    public static void main(String[] args) {
        int nums[] = { 10, 3, 5, 6, 2 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static long[] productExceptSelf(int nums[]) {
        // code here
        long temp = 1, c = 0;
        int n = nums.length, index = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0)
                temp *= nums[i];
            else {
                c++;
                index = i;
            }
        }
        long ans[] = new long[n];
        if (c > 1)
            return ans;
        if (c == 1) {
            ans[index] = temp;
            return ans;
        }
        for (int i = 0; i < n; i++) 
            ans[i] = temp / nums[i];
        return ans;
    }
}
