//GFG
//Game with String
//Time complexity: O(n+klog(p))  where n is the length of string and p is number of distinct alphabets 
//and k number of alphabets to be removed. 
//Space complexity: O(n)

package GFG;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class GameWithString_2 {

    public static void main(String[] args) {
        String s = "abccc";
        int k = 1;
        System.out.println(minValue(s, k));
    }

    static int minValue(String s, int k) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : map.values())
            pq.add(x);

        while (k > 0) {
            int curr = pq.poll();
            pq.add(curr - 1);
            k--;
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            ans += (curr * curr);
        }
        return ans;
    }
}
