//GFG
//Game with String
//Time complexity: O(n+klog(p))  where n is the length of string and p is number of distinct alphabets 
//and k number of alphabets to be removed. 
//Space complexity: O(n)

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class GameWithString {

    public static void main(String[] args) {
        String s = "abbccc";
        int k = 2;
        System.out.println(minValue(s, k));
    }

    public static int minValue(String s, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int mm[] = new int[26];
        Arrays.fill(mm, 0);
        for (int i = 0; i < s.length(); i++) {
            mm[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (mm[i] != 0)
                pq.add(mm[i]);
        }
        while (k != 0) {
            int temp = pq.remove();
            temp--;
            pq.add(temp);
            k--;
        }
        int ans = 0;
        while (pq.size() != 0) {
            int temp = pq.remove();
            ans += temp * temp;
        }
        return ans;
    }
}
