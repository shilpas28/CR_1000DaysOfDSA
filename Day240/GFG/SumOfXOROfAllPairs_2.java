//GFG
//Sum of XOR of all pairs
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class SumOfXOROfAllPairs_2 {

    public static void main(String[] args) {
        int arr[] = { 7, 3, 5 };
        int n = arr.length;
        System.out.println(sumXOR(arr, n));
    }

    // Function for finding maximum and value pair
    public static long sumXOR(int arr[], int n) {
        long sum = 0;
        for (int i = 0; i < 32; i++) {
            long one_cnt = 0, zero_cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] % 2 == 0)
                    zero_cnt++;
                else
                    one_cnt++;

                arr[j] /= 2;
            }
            sum += (zero_cnt * one_cnt) * (1 << i);
        }
        return sum;
    }
}
