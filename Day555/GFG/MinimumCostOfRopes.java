//GFG
//Minimum Cost of ropes
//Time complexity: O(nlogn)
//Space complexity: O(n) 

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    public static void main(String[] args) {
        long[] arr = { 4, 3, 2, 6 };
        System.out.println(minCost(arr));
    }

    // Function to return the minimum cost of connecting the ropes.
    public static long minCost(long[] arr) {
        // code here
        long ans = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (Long x : arr)
            pq.add(x);
        while (pq.size() != 1) {
            long first = pq.poll();
            long second = pq.poll();
            long total = first + second;
            pq.add(total);
            ans += total;
        }
        return ans;
    }
}
