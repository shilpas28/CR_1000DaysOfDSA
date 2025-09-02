//Leetcode
//3025. Find the Number of Ways to Place People I
//Time complexity: O(N^2)
//Space complexity: O(1)

public class FindTheNumberOfWaysToPlacePeopleI_3 {

    public static void main(String[] args) {
        int[][] points = { { 6, 2 }, { 4, 4 }, { 2, 6 } };
        System.out.println(numberOfPairs(points));
    }

    public static int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                if (points[i][0] <= points[j][0] && points[i][1] >= points[j][1]) {
                    boolean valid = true;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j)
                            continue;

                        if (points[k][0] >= points[i][0] && points[k][0] <= points[j][0] &&
                                points[k][1] >= points[j][1] && points[k][1] <= points[i][1]) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid)
                        count++;
                }
            }
        }
        return count;
    }
}
