//GFG
//Maximize median after doing k addition operation - Not accepted as TLE
//Time complexity: O(n * log k)
//Space complexity: O(1)

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximizeMedianAfterDoingKAdditionOperation {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 5 };
        int k = 3;
        System.out.println(maximizeMedian(arr, k));
    }

    public static int maximizeMedian(int[] arr, int k) {
        // code here
        int n = arr.length;
        int ind = 0;
        boolean fl = false;
        if (n % 2 == 0) {
            ind = (n / 2) - 1;
            fl = true;
        } else
            ind = (n / 2);

        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = ind; i < n; i++) {
            pq.add(arr[i]);
        }

        while (k-- > 0) {
            int a = pq.remove();
            a++;
            pq.add(a);
        }

        if (fl == false)
            return pq.remove();
        else {
            int a = pq.remove();
            int b = pq.remove();
            return (a + b) / 2;
        }
    }
}
