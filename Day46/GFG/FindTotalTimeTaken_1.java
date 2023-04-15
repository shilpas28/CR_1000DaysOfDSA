//GFG
//Find Total Time Taken
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashSet;

public class FindTotalTimeTaken_1 {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = { 1, 2, 3, 3 };
        int[] time = { 1, 2, 3, 4 };
        System.out.println(totalTime(n, arr, time));
    }

    public static long totalTime(int n, int arr[], int time[]) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                ans += time[arr[i] - 1];
                // System.out.println(time[arr[i]-1]);
            }
            else {
                set.add(arr[i]);
                ans++;
                // System.out.println("1");
            }
        }
        return ans - 1;
    }
}
