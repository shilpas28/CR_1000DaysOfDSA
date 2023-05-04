//GFG
//Max Coins
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.Comparator;

public class MaxCoins {

    public static void main(String[] args) {
        int n = 3;
        int[][] ranges = { { 1, 3, 4 }, { 2, 3, 5 }, { 3, 4, 2 } };
        System.out.println(maxCoins(n, ranges));
    }

    public static int maxCoins(int n, int ranges[][]) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        int temp[] = new int[n];
        temp[n - 1] = ranges[n - 1][2];
        for (int i = n - 2; i >= 0; i--)
            temp[i] = Math.max(temp[i + 1], ranges[i][2]);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = ranges[i][2];
            int low = i + 1, high = n - 1, t = 0;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (ranges[mid][0] >= ranges[i][1]) {
                    t = temp[mid];
                    high = mid - 1;
                } else
                    low = mid + 1;
            }
            sum += t;
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
