//GFG
//Activity Selection
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.Arrays;

public class ActivitySelection {

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int finish[] = { 2, 4, 6, 7, 9, 9 };
        System.out.println(activitySelection(start, finish));
    }

    public static int activitySelection(int[] start, int[] finish) {
        // code here.
        int[][] arr = new int[start.length][2];
        for (int i = 0; i < start.length; i++) {
            arr[i] = new int[] { start[i], finish[i] };
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        int end = -1;
        int count = 0;
        for (int i = 0; i < start.length; i++) {
            if (end < arr[i][0]) {
                count++;
                end = arr[i][1];
            }
        }
        return count;
    }
}
