//Leetcode
//2285. Maximum Total Importance of Roads
//Time complexity: O(nlogn)
//Space complexity: O(n)

import java.util.Arrays;

public class MaximumTotalImportanceOfRoads {

    public static void main(String[] args) {
        int n = 5;
        int[][] roads = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 2 }, { 1, 3 }, { 2, 4 } };
        System.out.println(maximumImportance(n, roads));
    }

    public static long maximumImportance(int n, int[][] roads) {
        long ans = 0, x = 1;
        long degree[] = new long[n];
        for (int road[] : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        for (long i : degree)
            ans += i * (x++);
        return ans;
    }
}
