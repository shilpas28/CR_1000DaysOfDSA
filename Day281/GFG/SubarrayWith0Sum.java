//GFG
//Subarray with 0 sum
//Time complexity: O(N)
//Space complexity: O(N) 

package GFG;

import java.util.HashSet;

public class SubarrayWith0Sum {

    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 4, 2, -3, 1, 6 };
        System.out.println(findsum(arr, n));
    }

    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[], int n) {
        // Your code here
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (set.contains(sum))
                return true;
            set.add(sum);
        }

        return false;
    }
}
