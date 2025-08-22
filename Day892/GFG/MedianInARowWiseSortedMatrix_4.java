//GFG
//Median in a row-wise sorted Matrix
//Time complexity: O(n log m * log(maxVal – minVal))
//Space complexity: O(1)

import java.util.PriorityQueue;

public class MedianInARowWiseSortedMatrix_4 {

    public static void main(String[] args) {
        int mat[][] = { { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 } };
        System.out.println(median(mat));
    }

    public static int median(int[][] mat) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] i : mat)
            for (int j : i)
                pq.offer(j);
        int n = pq.size() / 2;
        while (n > 0) {
            pq.poll();
            n--;
        }
        return pq.poll();
    }
}
