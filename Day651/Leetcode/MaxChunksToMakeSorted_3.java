//Leetcode
//769. Max Chunks To Make Sorted - Monotonic Increasing Stack
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.Stack;

public class MaxChunksToMakeSorted_3 {

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1, 0 };
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        // Stack to store the maximum elements of each chunk
        Stack<Integer> monotonicStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Case 1: Current element is larger, starts a new chunk
            if (monotonicStack.isEmpty() || arr[i] > monotonicStack.peek()) {
                monotonicStack.push(arr[i]);
            } else {
                // Case 2: Merge chunks
                int maxElement = monotonicStack.peek();
                while (!monotonicStack.isEmpty() && arr[i] < monotonicStack.peek()) {
                    monotonicStack.pop();
                }
                monotonicStack.push(maxElement);
            }
        }
        return monotonicStack.size();
    }
}
