//Leetcode
//826. Most Profit Assigning Work
//Time complexity: O(DlogD + WlogD)
//Space complexity: O(N)

package Leetcode;

import java.util.TreeMap;

public class MostProfitAssigningWork_2 {

    public static void main(String[] args) {
        int[] difficulty = { 2, 4, 6, 8, 10 }, profit = { 10, 20, 30, 40, 50 }, worker = { 4, 5, 6, 7 };
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }
        int best = 0, res = 0;
        for (Integer key : map.keySet()) {
            best = Math.max(map.get(key), best);
            map.put(key, best);
        }
        for (int i = 0; i < worker.length; i++) {
            res += map.floorEntry(worker[i]).getValue();
        }
        return res;
    }
}
