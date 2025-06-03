//Leetcode
//1298. Maximum Candies You Can Get from Boxes - BFS
//Time complexity: O(N+K)
//Space complexity: O(N)

import java.util.LinkedList;
import java.util.Queue;

public class MaximumCandiesYouCanGetFromBoxes_2 {

    public static void main(String[] args) {
        int[] status = { 1, 0, 1, 0 };
        int[] candies = { 7, 5, 4, 100 };
        int[][] keys = { {}, {}, { 1 }, {} };
        int[][] containedBoxes = { { 1, 2 }, { 3 }, {}, {} };
        int[] initialBoxes = { 0 };
        System.out.println(maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }

    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes,
            int[] initialBoxes) {
        Queue<Integer> queue = new LinkedList<>();
        for (int b : initialBoxes)
            queue.add(b);
        int total = 0;
        while (!queue.isEmpty()) {
            int box = queue.remove();
            if (status[box] == 0) {
                if (queue.isEmpty())
                    return total;
                queue.add(box);
            } else {
                total += candies[box];
                for (int key : keys[box])
                    status[key] = 1;
                for (int contained : containedBoxes[box])
                    queue.add(contained);
            }
        }
        return total;
    }
}
