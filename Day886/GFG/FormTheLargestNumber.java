//GFG
//Form the Largest Number
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class FormTheLargestNumber {

    public static void main(String[] args) {
        int arr[] = { 3, 30, 34, 5, 9 };
        System.out.println(findLargest(arr));
    }

    public static String findLargest(int[] arr) {
        // code here
        // Step 1: Convert integers to strings
        String[] strArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        // Step 2: Sort strings based on custom comparator
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: Handle edge case where the largest number is 0
        if (strArr[0].equals("0")) {
            return "0";
        }

        // Step 4: Build the largest number by concatenating sorted strings
        StringBuilder result = new StringBuilder();
        for (String str : strArr) {
            result.append(str);
        }

        return result.toString();
    }
}
