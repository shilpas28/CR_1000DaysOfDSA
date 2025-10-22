//GFG
//Nearly sorted
//Time complexity: O(nlogk)
//Space complexity: O(k)

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySorted {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 4 };
        int k = 2;
        nearlySorted(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static void nearlySorted(int[] arr, int k) {
        // code here
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
