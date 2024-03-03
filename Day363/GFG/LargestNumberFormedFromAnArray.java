//GFG
//Largest Number formed from an Array
//Time complexity: O(n*log(n))
//Space complexity: O(n) 

package GFG;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFormedFromAnArray {

    public static void main(String[] args) {
        int n = 5;
        String arr[] = { "3", "30", "34", "5", "9" };
        System.out.println(printLargest(n, arr));
    }

    static String printLargest(int n, String[] arr) {
        // code here
        StringBuilder temp = new StringBuilder();
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String a = x + y;
                String b = y + x;
                return b.compareTo(a);
            }
        });
        for (String x : arr)
            temp.append(x);
        return temp.toString();
    }
}
