//GFG 
//Maximum Diamonds
//Time complexity: O(NlogN)
//Space complexity: O(N)

package GFG;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumDiamonds_3 {
     public static void main(String[] args) {
        int N = 5, K = 3;
        int A[] = { 2, 1, 7, 4, 2 };
        System.out.println(maxDiamonds(A, N, K));
    }

    static long maxDiamonds(int[] A, int N, int K) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : A)
        pq.add(x);
        long ans=0;
        for(int i=0; i<K ; i++)
        {
            int curr =  pq.remove();
            ans+=curr;
            pq.add(curr/2);
        }
        return ans;
    }
}
