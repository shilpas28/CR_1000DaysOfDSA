//GFG
//Cake Distribution Problem
//Time complexity: O(NlogM), where M is the sum of elements in the array.
//Space complexity: O(1)

package GFG;

public class CakeDistributionProblem {

    public static void main(String[] args) {
        int N = 6, K = 2;
        int sweetness[] = { 6, 3, 2, 8, 7, 5 };
        System.out.println(maxSweetness(sweetness, N, K));
    }

    static int maxSweetness(int[] sweetness, int N, int K) {
        // Write your code here.
        int low = 0, high = 1000000000, ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (good(mid, sweetness, N, K)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static boolean good(int x, int[] sweetness, int n, int k) {
        int s = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            s += sweetness[i];
            if (s >= x) {
                s = 0;
                cnt++;
            }
        }
        return cnt >= k + 1;
    }
}
