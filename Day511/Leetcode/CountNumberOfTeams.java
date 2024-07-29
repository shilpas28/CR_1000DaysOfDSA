//Leetcode
//1395. Count Number of Teams
//Time complexity: O(N^2)
//Space complexity: O(1)

public class CountNumberOfTeams {

    public static void main(String[] args) {
        int[] rating = { 2, 5, 3, 4, 1 };
        System.out.println(numTeams(rating));
    }

    public static int numTeams(int[] rating) {
        int res = 0;
        for (int i = 1; i < rating.length - 1; ++i) {
            int less[] = new int[2], greater[] = new int[2];
            for (int j = 0; j < rating.length; ++j) {
                if (rating[i] < rating[j])
                    ++less[j > i ? 1 : 0];
                if (rating[i] > rating[j])
                    ++greater[j > i ? 1 : 0];
            }
            res += less[0] * greater[1] + greater[0] * less[1];
        }
        return res;
    }
}
