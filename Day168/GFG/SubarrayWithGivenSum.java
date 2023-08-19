//GFG
//Subarray with given sum
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;

public class SubarrayWithGivenSum {

    public static void main(String[] args) {
        int N = 5, S = 12;
        int A[] = { 1, 2, 3, 7, 5 };
        System.out.println(subarraySum(A, N, S));
    }

    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        boolean found = false;
        int st = 0;
        int end = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum >= s) {
                end = i;
                while (s < sum && st < end) {
                    sum -= arr[st++];

                }
            }
            if (sum == s) {
                al.add(st + 1);
                al.add(end + 1);
                found = true;
                break;
            }
        }
        if (!found)
            al.add(-1);
        return al;
    }
}
