//GFG
//Minimum Cost to cut a board into squares
//Time complexity: O(n*logn + m*logm)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class MinimumCostToCutABoardIntoSquares {

    public static void main(String[] args) {
        int n = 4, m = 6;
        int x[] = { 2, 1, 3, 1, 4 };
        int y[] = { 4, 1, 2 };
        System.out.println(minCost(n, m, x, y));
    }

    public static int minCost(int n, int m, int[] x, int[] y) {
        // code here
        Arrays.sort(x);
        Arrays.sort(y);
        reverse(x);
        reverse(y);

        int i = 0, j = 0;
        int total = 0, hp = 1, vp = 1;

        while (i < m - 1 && j < n - 1) {
            if (x[i] >= y[j]) {
                total += x[i] * hp;
                vp++;
                i++;
            } else {
                total += y[j] * vp;
                hp++;
                j++;
            }
        }

        while (i < m - 1) {
            total += x[i] * hp;
            i++;
        }
        while (j < n - 1) {
            total += y[j] * vp;
            j++;
        }

        return total;
    }

    static void reverse(int ar[]) {
        int i = 0, j = ar.length - 1;
        while (i < j) {
            int temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
            i++;
            j--;
        }
    }
}
