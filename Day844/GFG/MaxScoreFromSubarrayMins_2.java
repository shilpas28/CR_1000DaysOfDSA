//GFG
//Max Score from Subarray Mins
//Time complexity: O(N)
//Space complexity: O(1)

public class MaxScoreFromSubarrayMins_2 {

    public static void main(String[] args) {
        int arr[] = { 4, 3, 5, 1 };
        System.out.println(maxSum(arr));
    }

    public static int maxSum(int arr[]) {
        // code here
        int sum = 0;
        int maxi = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            sum = arr[i] + arr[i + 1];
            if (sum > maxi)
                maxi = sum;
        }
        return maxi;
    }
}
