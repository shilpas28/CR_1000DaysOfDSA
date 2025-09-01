//Leetcode
//1792. Maximum Average Pass Ratio - Priority Queue
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.PriorityQueue;

public class MaximumAveragePassRatio_2 {

    public static void main(String[] args) {
        int[][] classes = { { 1, 2 }, { 3, 5 }, { 2, 2 } };
        int extraStudents = 2;
        System.out.println(maxAverageRatio(classes, extraStudents));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {

        // Lambda to calculate the gain of adding an extra student
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] singleClass : classes) {
            int passes = singleClass[0];
            int totalStudents = singleClass[1];
            double gain = calculateGain(passes, totalStudents);
            maxHeap.offer(new double[] { gain, passes, totalStudents });
        }
        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] current = maxHeap.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            maxHeap.offer(
                    new double[] {
                            calculateGain(passes + 1, totalStudents + 1),
                            passes + 1,
                            totalStudents + 1,
                    });
        }
        // Calculate the final average pass ratio
        double totalPassRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            totalPassRatio += (double) passes / totalStudents;
        }
        return totalPassRatio / classes.length;
    }

    static double calculateGain(int passes, int totalStudents) {
        return ((double) (passes + 1) / (totalStudents + 1) -
                (double) passes / totalStudents);
    }
}
