//GFG
//Sort 0s, 1s and 2s - Optimal Approach
//Time complexity: O(N), where N = size of the given array. We are using a single loop that can run at most N times.
//Space complexity: O(1) as we are not using any extra space.

import java.util.ArrayList;

public class Sort0s1sAnd2s_3 {

    public static void main(String[] args) {
        // arr[]= [0, 2, 1, 2, 0]
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(2);
        arr.add(1);
        arr.add(2);
        arr.add(0);
        sort012(arr);
        System.out.println(arr);
    }

    // Function to sort an array of 0s, 1s, and 2s
    public static void sort012(ArrayList<Integer> arr) {
        // code here
        int n = arr.size();
        int low = 0, mid = 0, high = n - 1; // 3 pointers

        while (mid <= high) {
            if (arr.get(mid) == 0) {
                // swapping arr[low] and arr[mid]
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);

                low++;
                mid++;

            } else if (arr.get(mid) == 1) {
                mid++;

            } else {
                // swapping arr[mid] and arr[high]
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);

                high--;
            }
        }
    }
}
