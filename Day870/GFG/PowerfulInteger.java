//GFG
//Powerful Integer 
//Time complexity: O(Nlog N)
//Space complexity: O(N)

public class PowerfulInteger {

    public static void main(String[] args) {
        int intervals[][] = { { 1, 3 }, { 4, 6 }, { 3, 4 } };
        int k = 2;
        System.out.println(powerfulInteger(intervals, k));
    }

    public static int powerfulInteger(int[][] intervals, int k) {
        // code here
        int n = intervals.length;
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, intervals[i][1]);
        }

        int[] v = new int[mx + 3];
        for (int i = 0; i < n; i++) {
            v[intervals[i][0]] += 1;
            v[intervals[i][1] + 1] -= 1;
        }

        int ans = -1;
        for (int i = 1; i < mx + 3; i++) {
            v[i] = v[i - 1] + v[i];
            if (v[i] >= k) {
                ans = i;
            }
        }
        return ans;
    }
}
