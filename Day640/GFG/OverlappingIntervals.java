//GFG
//Overlapping Intervals
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervals {

    public static void main(String[] args) {
        int arr[][] = { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } };
        // System.out.println(mergeOverlap(arr));
        List<int[]> res = mergeOverlap(arr);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> ans = new ArrayList<>();
        ans.add(arr[0]);
        for (int i[] : arr) {
            if (i[0] <= ans.get(ans.size() - 1)[1]) {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], i[1]);
            } else {
                ans.add(i);
            }
        }
        return ans;
    }
}
