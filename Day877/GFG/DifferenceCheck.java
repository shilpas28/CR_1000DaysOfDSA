//GFG
//Difference Check
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class DifferenceCheck {

    public static void main(String[] args) {
        String[] arr = { "12:30:15", "12:30:45" };
        System.out.println(minDifference(arr));
    }

    public static int minDifference(String[] arr) {
        // code here
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        int total = 86400;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, totalTime(arr[i]) - totalTime(arr[i - 1]));
        }

        return Math.min(ans, total - (totalTime(arr[n - 1]) - totalTime(arr[0])));
    }

    static int totalTime(String s) {
        String[] temp = s.split(":");
        int hours = Integer.parseInt(temp[0]);
        int mins = Integer.parseInt(temp[1]);
        int secs = Integer.parseInt(temp[2]);
        return hours * 60 * 60 + mins * 60 + secs;
    }
}
