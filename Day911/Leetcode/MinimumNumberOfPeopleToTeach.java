//Leetcode
//1733. Minimum Number of People to Teach
//Time complexity: O(m*n)
//Space complexity: O(m+n)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumNumberOfPeopleToTeach {

    public static void main(String[] args) {
        int n = 2;
        int[][] languages = { { 1 }, { 2 }, { 1, 2 } };
        int[][] friendships = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        System.out.println(minimumTeachings(n, languages, friendships));
    }

    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> cncon = new HashSet<>();
        for (int[] friendship : friendships) {
            Map<Integer, Integer> mp = new HashMap<>();
            boolean conm = false;
            for (int lan : languages[friendship[0] - 1]) {
                mp.put(lan, 1);
            }
            for (int lan : languages[friendship[1] - 1]) {
                if (mp.containsKey(lan)) {
                    conm = true;
                    break;
                }
            }
            if (!conm) {
                cncon.add(friendship[0] - 1);
                cncon.add(friendship[1] - 1);
            }
        }
        int max_cnt = 0;
        int[] cnt = new int[n + 1];
        for (int friendship : cncon) {
            for (int lan : languages[friendship]) {
                cnt[lan]++;
                max_cnt = Math.max(max_cnt, cnt[lan]);
            }
        }
        return cncon.size() - max_cnt;
    }
}
