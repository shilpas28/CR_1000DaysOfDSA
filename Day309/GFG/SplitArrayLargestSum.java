//GFG
//Split Array Largest Sum
//Time complexity: O(N*log(sum(arr)))
//Space complexity: O(1)

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int N = 4, K = 3;
        int arr[] = { 1, 2, 3, 4 };
        System.out.println(splitArray(arr, N, K));
    }

    static int splitArray(int[] arr, int N, int K) {
        // code here
        int low = 0, high = 0;
        for (int num : arr) {
            high += num;
            low = Math.max(low, num);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(arr, N, K, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static boolean canSplit(int[] arr, int N, int K, int maxSum) {
        int sum = 0, count = 1;
        for (int num : arr) {
            if (sum + num > maxSum) {
                sum = 0;
                count++;
            }
            sum += num;
            if (count > K) {
                return false;
            }
        }
        return true;
    }
}
