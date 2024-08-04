//GFG
//N meetings in one room
//Time complexity: O(n) +O(n log n) + O(n) ~ O(n log n)
// O(n) to iterate through every position and insert them in a data structure. O(n log n)  to sort the data structure 
//in ascending order of end time. O(n)  to iterate through the positions and check which meeting can be performed.
//Space complexity: O(n)  since we used an additional data structure for storing the start time, end time, and meeting no.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NMeetingsInOneRoom {

    static class meeting {
        int start;
        int end;
        int pos;

        meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    static class meetingComparator implements Comparator<meeting> {
        @Override
        public int compare(meeting o1, meeting o2) {
            if (o1.end < o2.end)
                return -1;
            else if (o1.end > o2.end)
                return 1;
            else if (o1.pos < o2.pos)
                return -1;
            return 1;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int start[] = { 1, 3, 0, 5, 8, 5 }, end[] = { 2, 4, 6, 7, 9, 9 };
        System.out.println(maxMeetings(n, start, end));
    }

    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        ArrayList<meeting> meet = new ArrayList<>();

        for (int i = 0; i < start.length; i++)
            meet.add(new meeting(start[i], end[i], i + 1));

        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                answer.add(meet.get(i).pos);
            }
        }
        return answer.size();
    }
}
