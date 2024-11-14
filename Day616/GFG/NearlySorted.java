//GFG
//Nearly sorted
//Time complexity: O(NlogK)
//Space complexity: O(N) 

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySorted {

    public static void main(String[] args) {
        int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
        int k = 3;
        nearlySorted(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    // Non-static method, so you need to call it on an instance of the class
    public static void nearlySorted(int[] arr, int k) {
        // code
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            pq.offer(arr[i]);
            if (i >= k)
                arr[j++] = pq.poll();
        }
        while (!pq.isEmpty())
            arr[j++] = pq.poll();
    }
}
