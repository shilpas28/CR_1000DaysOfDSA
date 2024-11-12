//GFG
//Meeting Rooms
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class MeetingRooms {

    public static void main(String[] args) {
        int arr[][] = { { 1, 4 }, { 10, 15 }, { 7, 10 } };
        System.out.println(canAttend(arr));
    }

    static boolean canAttend(int[][] arr) {
        // Your code here
        Arrays.sort(arr, (row1, row2) -> Integer.compare(row1[1], row2[1]));
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i][0] < arr[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
