//GFG
//Split Array Largest Sum
//Time complexity: O(n*log(sum))
//Space complexity: O(1)

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 3;
        System.out.println(splitArray(arr, k));
    }

    public static int splitArray(int[] arr, int k) {
        // code here
        int N = arr.length;
        int low = 0, high = 0;
        for (int num : arr) {
            high += num;
            low = Math.max(low, num);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(arr, N, k, mid)) {
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
