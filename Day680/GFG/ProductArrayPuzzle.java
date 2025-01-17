//GFG
//Product array puzzle
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.Arrays;

public class ProductArrayPuzzle {

    public static void main(String[] args) {
        int arr[] = { 10, 3, 5, 6, 2 };
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int arr[]) {
        // code here
        int temp = 1, c = 0;
        int n = arr.length, index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                temp *= arr[i];
            else {
                c++;
                index = i;
            }
        }

        int ans[] = new int[n];
        if (c > 1)
            return ans;
        if (c == 1) {
            ans[index] = temp;
            return ans;
        }
        for (int i = 0; i < n; i++)
            ans[i] = temp / arr[i];
        return ans;
    }
}
