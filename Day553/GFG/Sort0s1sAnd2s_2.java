//GFG
//Sort 0s, 1s and 2s - Better Approach
//Time complexity: O(N) + O(N), where N = size of the array. First O(N) for counting the number of 0’s, 1’s, 2’s, and 
//second O(N) for placing them correctly in the original array.
//Space complexity: O(1) as we are not using any extra space.

import java.util.ArrayList;

@SuppressWarnings("all")
public class Sort0s1sAnd2s_2 {

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
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0)
                cnt0++;
            else if (arr.get(i) == 1)
                cnt1++;
            else
                cnt2++;
        }
        // Replace the places in the original array:
        for (int i = 0; i < cnt0; i++)
            arr.set(i, 0); // replacing 0's
        for (int i = cnt0; i < cnt0 + cnt1; i++)
            arr.set(i, 1); // replacing 1's
        for (int i = cnt0 + cnt1; i < n; i++)
            arr.set(i, 2); // replacing 2's
    }
}
