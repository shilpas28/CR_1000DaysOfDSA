//GFG
//Three way partitioning
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class ThreeWayPartitioning {

    public static void main(String[] args) {

        int array[] = { 1, 2, 3, 3, 4 };
        int a = 1, b = 2;
        threeWayPartition(array, a, b);
        System.out.println(Arrays.toString(array));
    }

    // Function to partition the array around the range such
    // that array is divided into three parts.
    public static void threeWayPartition(int array[], int a, int b) {
        // code here
        int j = 0, k = array.length - 1, i = 0;
        while (i <= k) {
            if (array[i] < a) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
                i++;
            } else if (array[i] > b) {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
                k--;
            } else
                i++;
        }
    }
}
