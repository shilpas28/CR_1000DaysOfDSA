//GFG
//Sort the given array after applying the given equation
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SortTheGivenArrayAfterApplyingTheGivenEquation_2 {

    public static void main(String[] args) {
        int arr[] = { -4, -2, 0, 2, 4 };
        int A = 1, B = 3, C = 5;
        System.out.println(sortArray(arr, A, B, C));
    }

    public static ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        // Code here
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int transformed = A * arr[i] * arr[i] + B * arr[i] + C;
            pq.add(transformed);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}
