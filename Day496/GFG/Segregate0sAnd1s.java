//GFG
//Segregate 0s and 1s
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class Segregate0sAnd1s {

    public static void main(String[] args) {
        int arr[] = { 0, 0, 1, 1, 0 };
        segregate0and1(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void segregate0and1(int[] arr) {
        // code here
        int zero = 0, one = arr.length - 1;
        while (zero < one) {
            if (arr[zero] == 1) {
                int temp = arr[zero];
                arr[zero] = arr[one];
                arr[one] = temp;
                one--;
            } else
                zero++;
        }
    }
}
