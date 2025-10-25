//GFG
//Minimum Steps to Halve Sum
//Time complexity: O(n + k*log(n))
//Space complexity: O(n)

import java.util.PriorityQueue;

public class MinimumStepsToHalveSum {

    public static void main(String[] args) {
        int arr[] = { 8, 6, 2 };
        System.out.println(minOperations(arr));
    }

    public static int minOperations(int[] arr) {
        // code here
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double sum = 0;
        for (int ele : arr) {
            pq.offer((double) ele);
            sum += (double) ele;
        }

        double div = sum / 2;
        int operation = 0;
        while (sum > div) {
            double top = pq.poll() / 2;
            sum -= top;
            pq.offer(top);
            operation++;
        }
        return operation;
    }
}
