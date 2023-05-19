//GFG
//Find k-th smallest element in given n ranges
//Time complexity: O(nlogn+q*n)
//Space complexity: O(q)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FindKthSmallestElementInGivenNRanges {

    public static void main(String[] args) {
        int n = 2, q = 3;
        int range[][] = { { 1, 4 }, { 6, 8 } };
        int queries[] = { 2, 6, 10 };
        System.out.println(kthSmallestNum(n, range, q, queries));
    }

    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        // code here
        Arrays.sort(range, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int temp = queries[i];
            int j = 0, last = -1, t;
            for (j = 0; j < n; j++) {
                if (range[j][1] > last && last >= range[j][0]) {
                    t = range[j][1] - last;
                    if (t >= temp) {
                        ans.add(last + temp);
                        break;
                    }
                    last = range[j][1];
                    temp -= t;
                } else if (range[j][1] > last) {
                    t = range[j][1] - range[j][0] + 1;
                    if (t >= temp) {
                        ans.add(range[j][0] + temp - 1);
                        break;
                    }
                    last = range[j][1];
                    temp -= t;
                }
            }
            if (j == n)
                ans.add(-1);
        }
        return ans;
    }
}
