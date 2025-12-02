//Leetcode
//3623. Count Number of Trapezoids I
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.Comparator;

public class CountNumberOfTrapezoidsI {

    public static void main(String[] args) {
        int[][] points = {{1, 0}, {2, 0}, {3, 0}, {2, 2}, {3, 2}};
        System.out.println(countTrapezoids(points));
    }

    public static int countTrapezoids(int[][] points) {
        int n = points.length, MOD = 1000000007;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        long res = 0, total = 0;
        for (int i = 0, j; i < n; i = j) {
            j = i + 1;
            while (j < n && points[i][1] == points[j][1]) {
                j++;
            }
            long count = j - i;
            long lines = count * (count - 1) / 2;
            res = (res + total * lines) % MOD;
            total = (total + lines) % MOD;
        }
        return (int) res;
    }
}
