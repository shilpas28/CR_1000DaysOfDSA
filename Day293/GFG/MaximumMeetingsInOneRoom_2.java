//GFG
//Maximum Meetings In One Room
//Time complexity: O(NlogN)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumMeetingsInOneRoom_2 {

    static class Pair {
        int st, end, index;

        Pair(int st, int end, int index) {
            this.st = st;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int N = 6;
        int[] S = { 1, 3, 0, 5, 8, 5 };
        int[] F = { 2, 4, 6, 7, 9, 9 };
        System.out.println(maxMeetings(N, S, F));
    }

    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // code here
        ArrayList<Pair> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            meetings.add(new Pair(S[i], F[i], i + 1));
        }
        Collections.sort(meetings, (a, b) -> Integer.compare(a.end, b.end));

        ArrayList<Integer> ans = new ArrayList<>();
        Pair prev = null;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                ans.add(meetings.get(i).index);
                prev = meetings.get(i);
            } else {
                if (meetings.get(i).st > prev.end) {
                    ans.add(meetings.get(i).index);
                    prev = meetings.get(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
