//Leetcode
//2225. Find Players With Zero or One Losses
//Time complexity: O(nlogn)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPlayersWithZeroOrOneLosses {

    public static void main(String[] args) {
        int[][] matches = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 }, { 10, 4 },
                { 10, 9 } };
        System.out.println(findWinners(matches));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> zeroLoss = new HashSet<>();
        Set<Integer> oneLoss = new HashSet<>();
        Set<Integer> moreLoss = new HashSet<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            // Add winner.
            if (!oneLoss.contains(winner) && !moreLoss.contains(winner)) {
                zeroLoss.add(winner);
            }

            // Add or move loser.
            if (zeroLoss.contains(loser)) {
                zeroLoss.remove(loser);
                oneLoss.add(loser);
            } else if (oneLoss.contains(loser)) {
                oneLoss.remove(loser);
                moreLoss.add(loser);
            } else if (moreLoss.contains(loser)) {
                continue;
            } else {
                oneLoss.add(loser);
            }
        }

        List<List<Integer>> answerList = new ArrayList<>();
        answerList.add(new ArrayList<>(zeroLoss));
        answerList.add(new ArrayList<>(oneLoss));

        int[][] answer = new int[2][];
        for (int i = 0; i < 2; i++) {
            answer[i] = new int[answerList.get(i).size()];
            for (int j = 0; j < answerList.get(i).size(); j++) {
                answer[i][j] = answerList.get(i).get(j);
            }
        }

        // Sorting winners in each category.
        Arrays.sort(answer[0]);
        Arrays.sort(answer[1]);

        List<List<Integer>> res = new ArrayList<>();
        for (int[] arr : answer) {
            List<Integer> temp = new ArrayList<>();
            for (int i : arr)
                temp.add(i);
            res.add(temp);
        }

        return res;
    }
}
