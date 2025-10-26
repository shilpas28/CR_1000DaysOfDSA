//GFG
//Minimum Cost of ropes
//Time complexity: O(nlogn)
//Space complexity: O(n)

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 6 };
        System.out.println(minCost(arr));
    }

    public static int minCost(int[] arr) {
        // code here
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr)
            pq.add(x);
        while (pq.size() != 1) {
            int first = pq.poll();
            int second = pq.poll();
            int total = first + second;
            pq.add(total);
            ans += total;
        }
        return ans;
    }
}
