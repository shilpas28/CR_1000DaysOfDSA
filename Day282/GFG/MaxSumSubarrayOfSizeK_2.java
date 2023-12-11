//GFG
//Max Sum Subarray of size K - Optimal method 
//Time complexity: O(N)
//Space compexity: O(1)

package GFG;

import java.util.ArrayList;

public class MaxSumSubarrayOfSizeK_2 {

    public static void main(String[] args) {
        int N = 4, K = 2;
        ArrayList<Integer> Arr = new ArrayList<>();
        Arr.add(100);
        Arr.add(200);
        Arr.add(300);
        Arr.add(400);
        System.out.println(maximumSumSubarray(K, Arr, N));
    }

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        // code here
        long curr_sum = 0, ans = Integer.MIN_VALUE;

        for (int i = 0; i < K; i++)
            curr_sum += Arr.get(i);

        ans = Math.max(ans, curr_sum);
        int j = 0;
        for (int i = K; i < N; i++) {
            curr_sum -= Arr.get(j++); // remove first ele of window
            curr_sum += Arr.get(i); // add new ele.
            ans = Math.max(ans, curr_sum);
        }
        return ans;
    }
}
