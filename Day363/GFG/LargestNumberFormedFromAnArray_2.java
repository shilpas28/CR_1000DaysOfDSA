//GFG
//Largest Number formed from an Array
//Time complexity: O(n*log(n))
//Space complexity: O(n) 

package GFG;

import java.util.Arrays;

public class LargestNumberFormedFromAnArray_2 {

    public static void main(String[] args) {
        int n = 5;
        String arr[] = { "3", "30", "34", "5", "9" };
        System.out.println(printLargest(n, arr));
    }

    static String printLargest(int n, String[] arr) {
        // code here
        Arrays.sort(arr, (x, y) -> (y + x).compareTo(x + y));
        // Joining the sorted array elements to form the final result
        return String.join("", arr);
    }
}
