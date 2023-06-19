//GFG
//Rearrange an array with O(1) extra space
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class RearrangeAnArrayWithO1ExtraSpace {

    public static void main(String[] args) {
        int N = 2;
        long arr[] = { 1, 0 };
        arrange(arr, N);
        System.out.println(Arrays.toString(arr));
    }

    static void arrange(long arr[], int n) {
        // your code here
        for (int i = 0; i < n; i++) {
            arr[i] += (arr[(int) arr[i]] % n) * n;
            // for the next iteration , we want the old values again for computation of
            // arr[i],
            // and for the retireval of old value we use %n as shown above
        }
        for (int i = 0; i < n; i++)
            arr[i] /= n;
    }
}
