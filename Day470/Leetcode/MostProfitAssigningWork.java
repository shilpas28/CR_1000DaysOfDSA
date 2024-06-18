//Leetcode
//826. Most Profit Assigning Work
//Time complexity: O(DlogD + WlogW)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.util.Pair;

public class MostProfitAssigningWork {

    public static void main(String[] args) {
        int[] difficulty = { 2, 4, 6, 8, 10 }, profit = { 10, 20, 30, 40, 50 }, worker = { 4, 5, 6, 7 };
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
        int N = profit.length, res = 0, i = 0, best = 0;
        for (int j = 0; j < N; ++j)
            jobs.add(new Pair<Integer, Integer>(difficulty[j], profit[j]));
        Collections.sort(jobs, Comparator.comparing(Pair::getKey));
        Arrays.sort(worker);
        for (int ability : worker) {
            while (i < N && ability >= jobs.get(i).getKey())
                best = Math.max(jobs.get(i++).getValue(), best);
            res += best;
        }
        return res;
    }
}
