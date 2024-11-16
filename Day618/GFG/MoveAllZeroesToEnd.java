//GFG
//Move All Zeroes to End - Brute force method 
//Time complexity: O(N) + O(X) + O(N-X) ~ O(2*N), where N = total no. of elements, X = no. of non-zero elements, 
//and N-X = total no. of zeros. Reason: O(N) for copying non-zero elements from the original to the temporary array. O(X) for 
//again copying it back from the temporary to the original array. O(N-X) for filling zeros in the original array. So, 
//the total time complexity will be O(2*N).
//Space complexity: O(N), as we are using a temporary array to solve this problem and the maximum size of the array can be N in 
//the worst case. Reason: The temporary array stores the non-zero elements. In the worst case, all the given array elements will 
//be non-zero.

import java.util.ArrayList;
import java.util.Arrays;

public class MoveAllZeroesToEnd {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 0, 4, 3, 0, 5, 0 };
        pushZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void pushZerosToEnd(int[] arr) {
        // code here
        // temporary array:
        ArrayList<Integer> temp = new ArrayList<>();
        // copy non-zero elements
        // from original -> temp array:
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                temp.add(arr[i]);
        }
        // number of non-zero elements.
        int nz = temp.size();
        // copy elements from temp
        // fill first nz fields of
        // original array:
        for (int i = 0; i < nz; i++) {
            arr[i] = temp.get(i);
        }
        // fill rest of the cells with 0:
        for (int i = nz; i < n; i++) {
            arr[i] = 0;
        }
    }
}
