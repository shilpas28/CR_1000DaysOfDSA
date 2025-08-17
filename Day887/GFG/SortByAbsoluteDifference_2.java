//GFG
//Sort by Absolute Difference
//Time complexity: O(NlogN)
//Space complexity: O(1) (1 data structure fro storage)

import java.util.Arrays;

public class SortByAbsoluteDifference_2 {

    public static void main(String[] args) {
        int x = 7;
        int arr[] = { 10, 5, 3, 9, 2 };
        rearrange(arr, x);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int[] arr, int x) {
        // code here
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> (Math.abs(x - a) - Math.abs(x - b)));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
