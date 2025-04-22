//GFG
//Unique Number I
//Time complexity: O(NlogN)
//Space complexity: O(1) 

import java.util.Arrays;

public class UniqueNumberI {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 5, 5 };
        System.out.println(findUnique(arr));
    }

    public static int findUnique(int[] arr) {
        // code here
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] != arr[i + 1]) {
                return arr[i];
            }
            i += 2;
        }
        return arr[arr.length - 1];
    }
}
