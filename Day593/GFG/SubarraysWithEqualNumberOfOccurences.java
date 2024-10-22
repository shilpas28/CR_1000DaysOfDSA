//GFG
//Sub-arrays with equal number of occurences
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithEqualNumberOfOccurences {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };
        int x = 4, y = 6;
        System.out.println(sameOccurrence(arr, x, y));
    }

    static int sameOccurrence(int arr[], int x, int y) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int countX = 0, countY = 0;
        int ans = 0;
        for (int ele : arr) {
            if (ele == x)
                ++countX;

            if (ele == y)
                ++countY;

            int diff = countX - countY;
            if (map.containsKey(diff))
                ans += map.get(diff);

            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return ans;
    }
}
