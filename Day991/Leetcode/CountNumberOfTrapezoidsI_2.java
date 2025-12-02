//Leetcode
//3623. Count Number of Trapezoids I
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfTrapezoidsI_2 {

    public static void main(String[] args) {
        int[][] points = {{1, 0}, {2, 0}, {3, 0}, {2, 2}, {3, 2}};
        System.out.println(countTrapezoids(points));
    }

    public static int countTrapezoids(int[][] points) {
        Map<Integer, Integer> pointNum = new HashMap<>();
        final int mod = 1000000007;
        long ans = 0;
        long sum = 0;
        for (int[] point : points) {
            pointNum.put(point[1], pointNum.getOrDefault(point[1], 0) + 1);
        }
        for (int pNum : pointNum.values()) {
            long edge = ((long) pNum * (pNum - 1)) / 2;
            ans = (ans + edge * sum) % mod;
            sum = (sum + edge) % mod;
        }
        return (int) ans;
    }
}
