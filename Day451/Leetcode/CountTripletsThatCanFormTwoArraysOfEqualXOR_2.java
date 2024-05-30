//Leetcode
//1442. Count Triplets That Can Form Two Arrays of Equal XOR
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR_2 {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 6, 7 };
        System.out.println(countTriplets(arr));
    }

    public static int countTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                val = val ^ arr[k];

                if (val == 0) {
                    count += (k - i);
                }
            }
        }
        return count;
    }
}
