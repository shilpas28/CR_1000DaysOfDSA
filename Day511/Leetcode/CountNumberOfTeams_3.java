//Leetcode
//1395. Count Number of Teams
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.TreeSet;

public class CountNumberOfTeams_3 {

    public static void main(String[] args) {
        int[] rating = { 2, 5, 3, 4, 1 };
        System.out.println(numTeams(rating));
    }

    public static int numTeams(int[] rating) {
        if (rating.length < 3)
            return 0;

        int N = rating.length;
        TreeSet<Integer> leftSet = new TreeSet<>();
        TreeSet<Integer> rightSet = new TreeSet<>();

        for (int i = N - 1; i >= 0; --i)
            rightSet.add(rating[i]);

        int res = 0;
        for (int i = 0; i < N; ++i) {
            int r = rating[i];

            rightSet.remove(r);
            res += (leftSet.headSet(r).size() * rightSet.tailSet(r).size()); // count increase
            res += (leftSet.tailSet(r).size() * rightSet.headSet(r).size()); // count decrease
            leftSet.add(r);
        }
        return res;
    }
}
