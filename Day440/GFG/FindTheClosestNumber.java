//GFG
//Find the closest number
//Time complexity: O(logN)
//Space complexity: O(1)

package GFG;

public class FindTheClosestNumber {

    public static void main(String[] args) {
        int n = 4, k = 4;
        int arr[] = { 1, 3, 6, 7 };
        System.out.println(findClosest(n, k, arr));
    }

    public static int findClosest(int n, int k, int[] arr) {
        // code here
        int low = 0, high = n - 1, mid = 0, mn = Integer.MAX_VALUE, ans = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            int diff = Math.abs(arr[mid] - k);
            if (diff <= mn) {
                if (diff == mn)
                    ans = Math.max(ans, arr[mid]);
                else
                    ans = arr[mid];
                mn = diff;
            }
            if (arr[mid] <= k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return ans;
    }
}
