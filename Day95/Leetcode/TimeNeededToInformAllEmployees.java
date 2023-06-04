//Leetcode
//1376. Time Needed to Inform All Employees - using BFS
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class TimeNeededToInformAllEmployees {

    public static void main(String[] args) {
        int n = 1, headID = 0;
        int[] manager = { -1 };
        int[] informTime = { 0 };
        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }

    static int time_needed = 0;

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; ++i)
            res = Math.max(res, dfs(i, manager, informTime));
        return res;
    }
    public static int dfs(int i, int[] manager, int[] informTime) {
        if (manager[i] != -1) {
            informTime[i] += dfs(manager[i], manager, informTime);
            manager[i] = -1;
        }
        return informTime[i];
    }

}
