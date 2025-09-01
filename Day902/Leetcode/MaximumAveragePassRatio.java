//Leetcode
//1792. Maximum Average Pass Ratio - Brute Force - Not accepted as TLE
//Time complexity: O(k*N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.List;

public class MaximumAveragePassRatio {

    public static void main(String[] args) {
        int[][] classes = { { 1, 2 }, { 3, 5 }, { 2, 2 } };
        int extraStudents = 2;
        System.out.println(maxAverageRatio(classes, extraStudents));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        List<Double> passRatios = new ArrayList<>();
        // Calculate initial pass ratios
        for (int classIndex = 0; classIndex < classes.length; classIndex++) {
            double initialRatio = (double) classes[classIndex][0] / classes[classIndex][1];
            passRatios.add(initialRatio);
        }

        while (extraStudents > 0) {
            List<Double> updatedRatios = new ArrayList<>();
            // Calculate updated pass ratios if an extra student is added
            for (int classIndex = 0; classIndex < classes.length; classIndex++) {
                double newRatio = (double) (classes[classIndex][0] + 1) /
                        (classes[classIndex][1] + 1);
                updatedRatios.add(newRatio);
            }

            int bestClassIndex = 0;
            double maximumGain = 0;
            // Find the class that gains the most from an extra student
            for (int classIndex = 0; classIndex < updatedRatios.size(); classIndex++) {
                double gain = updatedRatios.get(classIndex) - passRatios.get(classIndex);
                if (gain > maximumGain) {
                    bestClassIndex = classIndex;
                    maximumGain = gain;
                }
            }
            // Update the selected class
            passRatios.set(bestClassIndex, updatedRatios.get(bestClassIndex));
            classes[bestClassIndex][0]++;
            classes[bestClassIndex][1]++;
            extraStudents--;
        }
        // Calculate the total average pass ratio
        double totalPassRatio = 0;
        for (double passRatio : passRatios) {
            totalPassRatio += passRatio;
        }
        return totalPassRatio / classes.length;
    }
}
