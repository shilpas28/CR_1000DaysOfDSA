//GFG
//Sort 0s, 1s and 2s - Brute Force Approach
//Time complexity: O(N*logN)
//Space complexity: O(1) 

import java.util.ArrayList;
import java.util.Collections;

public class Sort0s1sAnd2s {

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
        Collections.sort(arr);
    }
}
