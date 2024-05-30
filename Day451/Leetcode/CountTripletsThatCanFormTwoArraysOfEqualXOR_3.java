//Leetcode
//1442. Count Triplets That Can Form Two Arrays of Equal XOR
//Time complexity: O(n)
//Space complexity: O(n)

package Leetcode;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR_3 {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 6, 7 };
        System.out.println(countTriplets(arr));
    }

    public static int countTriplets(int[] arr) {

        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (prefix[i] == prefix[k + 1]) {
                    count += (k - i);
                }
            }
        }
        return count;
    }
}
