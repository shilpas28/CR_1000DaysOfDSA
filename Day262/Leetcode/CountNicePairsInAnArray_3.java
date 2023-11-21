//leetcode
//1814. Count Nice Pairs in an Array
//Time complexity: O(n) - where (n) is the length of the input array. The algorithm iterates through the array once.
//Space complexity: O(n) - where (n) is the number of unique temporary numbers. The HashMap stores the occurrences of 
//temporary numbers.

package Leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInAnArray_3 {

    public static void main(String[] args) {
        int[] nums = { 42, 11, 1, 97 };
        System.out.println(countNicePairs(nums));
    }

    public static int countNicePairs(int[] nums) {
        // Create a HashMap to store occurrences of temporary numbers
        Map<Integer, Integer> numbers = new HashMap<>();
        // Iterate through the array
        for (int num : nums) {
            // Calculate the temporary number
            int temporary_number = num - reverse(num);
            // Update the count in the HashMap
            if (numbers.containsKey(temporary_number)) {
                numbers.put(temporary_number, numbers.get(temporary_number) + 1);
            } else {
                numbers.put(temporary_number, 1);
            }
        }
        // Calculate the total number of nice pairs
        long result = 0;
        Collection<Integer> values = numbers.values();
        int mod = 1000000007;
        for (int value : values) {
            result = (result % mod + ((long) value * ((long) value - 1) / 2)) % mod;
        }
        // Return the result as an integer
        return (int) result;
    }

    // Helper function to reverse a number
    static int reverse(int number) {
        int reversed_number = 0;
        while (number > 0) {
            reversed_number = reversed_number * 10 + number % 10;
            number /= 10;
        }
        return reversed_number;
    }
}
