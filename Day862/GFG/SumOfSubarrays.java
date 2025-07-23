//GFG
//Sum of Subarrays
//Time complexity: O(N)
//Space complexity: O(1)

public class SumOfSubarrays {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(subarraySum(arr));
    }

    public static int subarraySum(int[] arr) {
        // code here
        int n = arr.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i] * (i + 1) * (n - i);
        }
        return totalSum;
    }
}
