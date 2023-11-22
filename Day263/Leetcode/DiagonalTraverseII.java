//Leetcode
//1424. Diagonal Traverse II
//Time complexity: O(n) - Here, 'n' will be total time, (row * column).Becoz the input is jagged array, so included like this.
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraverseII {

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(1, 2, 3));
        nums.add(Arrays.asList(4, 5, 6));
        nums.add(Arrays.asList(7, 8, 9));
        System.out.println(Arrays.toString(findDiagonalOrder(nums)));
    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums.size(), size = 0;

        for (int i = 0; i < m; i++) {
            int n = nums.get(i).size(), x = i;
            for (int j = 0; j < n; j++) {
                if (res.size() == x) {
                    res.add(new ArrayList<>());
                }
                res.get(x).add(nums.get(i).get(j));
                x++;
                size++;
            }
        }
        int[] ans = new int[size];
        int idx = 0;

        for (int i = 0; i < res.size(); i++) {
            for (int j = res.get(i).size() - 1; j >= 0; j--) {
                ans[idx] = res.get(i).get(j);
                idx++;
            }
        }
        return ans;
    }
}
