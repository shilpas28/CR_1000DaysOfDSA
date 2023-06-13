//GFG
//K Largest Elements
//Time complexity: O(N + KlogK)
//Space complexity: O(K+(N-K)*logK)

package GFG;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {

    public static void main(String[] args) {
        int N = 5, K = 2;
        int Arr[] = { 12, 5, 787, 1, 23 };
        System.out.println(Arrays.toString(kLargest(Arr, N, K)));
    }

    public static int[] kLargest(int[] arr, int n, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if (pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        int ans[] = new int[k];
        int i = k - 1;
        while (pq.size() != 0) {
            ans[i--] = pq.peek();
            pq.poll();
        }
        return ans;
    }
}
