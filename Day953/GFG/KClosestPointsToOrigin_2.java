//GFG
//K Closest Points to Origin
//Time complexity: O(nlogk)
//Space complexity: O(k)

import java.util.ArrayList;
import java.util.Arrays;

public class KClosestPointsToOrigin_2 {

    public static void main(String[] args) {
        int k = 2;
        int points[][] = { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 1 } };
        System.out.println(kClosest(points, k));
    }

    public static ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Arrays.sort(points, java.util.Comparator.comparingInt(o -> o[0] * o[0] + o[1] * o[1]));
        int idx = 0;

        while (k-- > 0) {
            ArrayList<Integer> list = new ArrayList<>();

            list.add(points[idx][0]);
            list.add(points[idx++][1]);

            ans.add(list);
        }

        return ans;
    }
}
