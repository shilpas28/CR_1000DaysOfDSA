//GFG - not accepted as TLE
//Task Scheduler
//Time complexity: O(NlogN)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    public static void main(String[] args) {
        int N = 6;
        int K = 2;
        char task[] = { 'A', 'A', 'A', 'B', 'B', 'B' };
        System.out.println(leastInterval(N, K, task));
    }

    static int leastInterval(int N, int K, char tasks[]) {
        // code here
        Map<Character, Integer> counts = new HashMap();
        for (char t : tasks)
            counts.put(t, counts.getOrDefault(t, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue(counts.size(), Collections.reverseOrder());
        pq.addAll(counts.values());
        int result = 0;
        while (!pq.isEmpty()) {
            int time = 0;
            List<Integer> tmp = new ArrayList();
            for (int i = 0; i < K + 1; ++i) {
                if (!pq.isEmpty()) {
                    tmp.add(pq.remove() - 1);
                    time++;
                }
            }
            for (int t : tmp)
                if (t > 0)
                    pq.add(t);
            result += pq.isEmpty() ? time : K + 1;
        }
        return result;
    }
}
