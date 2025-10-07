//Leetcode
//1488. Avoid Flood in The City
//Time complexity: O(nlogn)
//Space complexity: O(n)

package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFloodInTheCity {

    public static void main(String[] args) {
        int[] rains = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(avoidFlood(rains)));
    }

    public static int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        TreeSet<Integer> st = new TreeSet<Integer>();
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] == 0) {
                st.add(i);
            } else {
                ans[i] = -1;
                if (mp.containsKey(rains[i])) {
                    Integer it = st.ceiling(mp.get(rains[i]));
                    if (it == null) {
                        return new int[0];
                    }
                    ans[it] = rains[i];
                    st.remove(it);
                }
                mp.put(rains[i], i);
            }
        }
        return ans;
    }
}
