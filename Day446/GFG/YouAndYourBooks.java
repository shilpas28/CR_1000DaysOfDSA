//GFG
//You and your books
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class YouAndYourBooks {

    public static void main(String[] args) {
        int n = 8, k = 1;
        int[] arr = { 3, 2, 2, 3, 1, 1, 1, 3 };
        System.out.println(max_Books(arr, n, k));
    }

    static long max_Books(int arr[], int n, int k) {
        // Your code here
        long ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k)
                sum += arr[i];
            else {
                ans = Math.max(ans, sum);
                sum = 0;
            }
        }
        ans = Math.max(sum, ans);
        return ans;
    }
}
