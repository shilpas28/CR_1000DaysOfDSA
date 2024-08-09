//GFG
//Maximize Array Value After Rearrangement
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class MaximizeArrayValueAfterRearrangement {

    public static void main(String[] args) {
        int arr[] = { 5, 3, 2, 4, 1 };
        System.out.println(Maximize(arr));
    }

    static int Maximize(int arr[]) {
        // Complete the function
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            long temp = (long) arr[i] * i;
            sum += temp;
        }
        return (int) (sum % 1000000007);
    }
}
