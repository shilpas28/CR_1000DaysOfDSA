//N meetings in one room
//Time complexity: O(n log n) 
//Space complexity: O(n)  

import java.util.Arrays;

public class NMeetingsInOneRoom_2 {

    public static void main(String[] args) {
        int n = 6;
        int start[] = { 1, 3, 0, 5, 8, 5 }, end[] = { 2, 4, 6, 7, 9, 9 };
        System.out.println(maxMeetings(n, start, end));
    }

    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        if (n == 0)
            return 0;
        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        int ans = 1;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        int eTime = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (eTime < arr[i][0]) {
                ans++;
                eTime = arr[i][1];
            }
        }
        return ans;
    }
}
