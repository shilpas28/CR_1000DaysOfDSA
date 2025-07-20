//GFG
//Count Numbers Containing Specific Digits
//Time complexity: O(logN)
//Space complexity: O(1)

import java.util.HashSet;

public class CountNumbersContainingSpecificDigits {

    public static void main(String[] args) {
        int n = 2;
        int arr[] = { 3, 5 };
        System.out.println(countValid(n, arr));
    }

    public static int countValid(int n, int[] arr) {
        // code here
        long totalNumbers = 9 * (long) Math.pow(10, n - 1);

        HashSet<Integer> forbiddenDigits = new HashSet<>();
        for (int digit : arr) {
            forbiddenDigits.add(digit);
        }

        int allowedCount = 10 - forbiddenDigits.size();
        long invalidNumbers;

        if (forbiddenDigits.contains(0))
            invalidNumbers = (long) Math.pow(allowedCount, n);
        else
            invalidNumbers = (long) (allowedCount - 1) * (long) Math.pow(allowedCount, n - 1);

        long result = totalNumbers - invalidNumbers;
        return (int) result;
    }
}
