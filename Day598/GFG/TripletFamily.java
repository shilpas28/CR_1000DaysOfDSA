//GFG
//Triplet Family
//Time complexity: O(N^2)
//Space complexity: O(1) 

import java.util.Arrays;

public class TripletFamily {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(findTriplet(arr));
    }

    public static boolean findTriplet(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = n - 1; i >= 0; --i) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if (arr[j] + arr[k] == arr[i])
                    return true;
                else if (arr[j] + arr[k] < arr[i])
                    ++j;
                else
                    --k;
            }
        }
        return false;
    }
}
