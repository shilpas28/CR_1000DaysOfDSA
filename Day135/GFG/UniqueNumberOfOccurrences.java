//GFG
//Unique Number of Occurrences
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        int N = 5;
        int[] arr = { 1, 1, 2, 5, 5 };
        System.out.println(isFrequencyUnique(N, arr));
    }

    public static boolean isFrequencyUnique(int n, int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr)
            map.put(x, map.getOrDefault(x, 0) + 1);
        Set<Integer> set = new HashSet<>();
        for (int x : map.values()) {
            if (set.contains(x))
                return false;

            set.add(x);
        }
        return true;
    }
}
