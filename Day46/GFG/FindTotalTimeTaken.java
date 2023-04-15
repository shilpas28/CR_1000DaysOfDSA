//GFG - not accepted by GFG as code is failing 
//Find Total Time Taken
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;

public class FindTotalTimeTaken {

    public static void main(String[] args) {
        int n = 4;
        int[] arr = { 1, 2, 3, 3 };
        int[] time = { 1, 2, 3, 4 };
        System.out.println(totalTime(n, arr, time));
    }

    public static long totalTime(int n, int arr[], int time[]) {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(arr[0], 0L);
        long ctime = 0;

        for (int i = 1; i < n; i++) {
            long lastEncountered = map.containsKey(arr[i]) ? map.get(arr[i]) : -1;
            if (lastEncountered == -1) {
                ctime += 1;
            } else {
                if ((ctime - lastEncountered) >= time[arr[i] - 1])
                    ctime++;
                else
                    ctime += (time[arr[i] - 1] - (ctime - lastEncountered));
            }
            map.put(arr[i], ctime);
        }
        return ctime;
    }
}
