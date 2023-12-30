//GFG
//Winner of an election
//Time complexity: O(n)
//Space complexity: O(n) 

import java.util.Arrays;
import java.util.HashMap;

public class WinnerOfAnElection {

    public static void main(String[] args) {
        int n = 13;
        String arr[] = { "john", "johnny", "jackie", "johnny", "john",
                "jackie", "jamie", "jamie", "john", "johnny", "jamie",
                "johnny", "john" };
        System.out.println(Arrays.toString(winner(arr, n)));
    }

    // Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n) {
        // add your code
        HashMap<String, Integer> hm = new HashMap<>();
        String res[] = new String[2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            max = Math.max(hm.get(arr[i]), max);
        }

        for (String key : hm.keySet()) {
            if (hm.get(key) == max) {
                if (res[0] == null)
                    res[0] = key;
                else {
                    if (res[0].compareTo(key) > 0)
                        res[0] = key;
                }
            }
        }
        res[1] = String.valueOf(max);
        return res;
    }
}
