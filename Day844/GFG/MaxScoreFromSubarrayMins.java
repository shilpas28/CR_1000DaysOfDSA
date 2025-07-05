//GFG
//Max Score from Subarray Mins
//Time complexity: O(N)
//Space complexity: O(1)

public class MaxScoreFromSubarrayMins {

    public static void main(String[] args) {
        int arr[] = { 4, 3, 5, 1 };
        System.out.println(maxSum(arr));
    }

    public static int maxSum(int arr[]) {
        // code here
        int prev = arr[0];
        int n = arr.length;
        int maxsum = 0;
        for (int i = 1; i < n; i++) {
            maxsum = Math.max(maxsum, arr[i] + prev);
            prev = arr[i];
        }
        return maxsum;
    }
}
