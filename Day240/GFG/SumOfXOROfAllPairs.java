//GFG
//Sum of XOR of all pairs - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

public class SumOfXOROfAllPairs {

    public static void main(String[] args) {
        int arr[] = { 7, 3, 5 };
        int n = arr.length;
        System.out.println(sumXOR(arr, n));
    }

    // Function for finding maximum and value pair
    public static long sumXOR(int arr[], int n) {
        // Complete the function
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ans += (arr[i] ^ arr[j]);
            }
        }
        return ans;
    }
}
