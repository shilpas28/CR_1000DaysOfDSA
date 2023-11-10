//Leetcode
//1743. Restore the Array From Adjacent Pairs - using BFS
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RestoreTheArrayFromAdjacentPairs_2 {

    public static void main(String[] args) {
        int[][] adjacentPairs = { { 2, 1 }, { 3, 4 }, { 3, 2 } };
        System.out.println(Arrays.toString(restoreArray(adjacentPairs)));
    }

    public static int[] restoreArray(int[][] adjacentPairs) {
        // length of restoredArray would be input length+1
        int[] restoredArray = new int[adjacentPairs.length + 1];

        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

        // 1. Build graph of number -> [adjacent numbers]
        for (int i = 0; i < adjacentPairs.length; i++) {
            addToGraph(graph, adjacentPairs[i][0], adjacentPairs[i][1]);
            addToGraph(graph, adjacentPairs[i][1], adjacentPairs[i][0]);
        }

        // 2. Find first number with only one adjacent number i.e. in-degree = 1. That
        // wil be our start.
        // eg. get -3 or -2 as our start.
        // There would always be two elements which satisfy this conditon & starting
        // from either would suffice.
        int start = 0;
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                start = key;
                break;
            }
        }
        List<Integer> answerList = new ArrayList<Integer>();
        bfs(start, graph, restoredArray);

        for (int i = 0; i < answerList.size(); i++) {
            restoredArray[i] = answerList.get(i);
        }
        return restoredArray;
    }

    /****** Template BFS Code *******/
    static void bfs(int start, Map<Integer, List<Integer>> graph, int[] restoredArray) {
        Queue<Integer> bfsQueue = new LinkedList<Integer>();
        Set<Integer> seenSet = new HashSet<Integer>();
        bfsQueue.add(start);
        seenSet.add(start);

        int index = 0;

        while (!bfsQueue.isEmpty()) {

            int restoredValue = bfsQueue.poll();
            List<Integer> neighbors = graph.get(restoredValue);
            restoredArray[index++] = restoredValue;
            // loop over adjacents like you do in BFS, here adjacenets are fetched from the
            // constructed graph.
            for (Integer curr : neighbors) {
                if (!seenSet.contains(curr)) {
                    bfsQueue.offer(curr);
                    seenSet.add(curr);
                }
            }
        }
    }

    // Utility function which simply builds graph of [numbers] -> [list of adjacent
    // numbers]
    // eg. [[4,-2],[1,4],[-3,1]]
    // map will be 4 ->[-2,1], 1->[-3,4], -2->[4], -3->[1]
    static void addToGraph(Map<Integer, List<Integer>> graph, int key, int value) {
        if (graph.containsKey(key)) {
            graph.get(key).add(value);
        } else {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(value);
            graph.put(key, temp);
        }
    }
}
