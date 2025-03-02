//GFG
//K Sized Subarray Maximum
//Time complexity: O(N)
//Space complexity: O(k)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class KSizedSubarrayMaximum {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        System.out.println(maxOfSubarrays(arr, k));
    }

    public static ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (dq.size() != 0 && dq.getFirst() == i - k)
                dq.removeFirst();
            while (dq.size() != 0 && arr[dq.getLast()] <= arr[i])
                dq.removeLast();
            dq.add(i);
            if (i >= k - 1)
                ans.add(arr[dq.getFirst()]);
        }
        return ans;
    }
}
