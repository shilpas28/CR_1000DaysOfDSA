//Leetcode
//2406. Divide Intervals Into Minimum Number of Groups - Method 3
//Time complexity: O(N)
//Space complexity: O(N)

public class DivideIntervalsIntoMinimumNumberOfGroups_3 {

    public static void main(String[] args) {
        int[][] intervals = { { 5, 10 }, { 6, 8 }, { 1, 5 }, { 2, 3 }, { 1, 10 } };
        System.out.println(minGroups(intervals));
    }

    public static int minGroups(int[][] intervals) {
        int[] count = new int[1000002];
        for (int[] in : intervals) {
            count[in[0]]++;
            count[in[1] + 1]--;
        }

        int max = 0;
        for (int i = 1; i < 1000002; i++) {
            count[i] += count[i - 1];
            max = Math.max(max, count[i]);
        }
        return max;
    }
}
