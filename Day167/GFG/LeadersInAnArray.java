//GFG
//Leaders in an array
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInAnArray {

    public static void main(String[] args) {
        int n = 6;
        int A[] = { 16, 17, 4, 3, 5, 2 };
        System.out.println(leaders(A, n));
    }

    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n) {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= list.get(list.size() - 1))
                list.add(arr[i]);
        }
        Collections.reverse(list);
        return list;
    }
}
