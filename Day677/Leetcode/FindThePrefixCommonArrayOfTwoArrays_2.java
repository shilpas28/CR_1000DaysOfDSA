//Leetcode
//2657. Find the Prefix Common Array of Two Arrays - Hash Set
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindThePrefixCommonArrayOfTwoArrays_2 {

    public static void main(String[] args) {
        int[] A = { 1, 3, 2, 4 };
        int[] B = { 3, 1, 2, 4 };
        System.out.println(Arrays.toString(findThePrefixCommonArray(A, B)));
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];
        // Initialize sets to store elements from A and B
        Set<Integer> elementsInA = new HashSet<Integer>();
        Set<Integer> elementsInB = new HashSet<Integer>();
        // Iterate through the elements of both arrays
        for (int currentIndex = 0; currentIndex < n; ++currentIndex) {
            // Add current elements from A and B to respective sets
            elementsInA.add(A[currentIndex]);
            elementsInB.add(B[currentIndex]);
            int commonCount = 0;
            // Count common elements between the sets
            for (int element : elementsInA) {
                if (elementsInB.contains(element)) {
                    ++commonCount;
                }
            }
            // Store the count of common elements for the current prefix
            prefixCommonArray[currentIndex] = commonCount;
        }
        // Return the final array with counts of common elements in each prefix
        return prefixCommonArray;
    }
}
