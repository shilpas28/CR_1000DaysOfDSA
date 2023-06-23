//GFG - not accepted as TLE
//Task Scheduler
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class TaskScheduler_2 {
    public static void main(String[] args) {
        int N = 6;
        int K = 2;
        char task[] = { 'A', 'A', 'A', 'B', 'B', 'B' };
        System.out.println(leastInterval(N, K, task));
    }

    static int leastInterval(int N, int K, char tasks[]) {
        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;
        return Math.max(tasks.length, (c[25] - 1) * (K + 1) + 25 - i);
    }
}
