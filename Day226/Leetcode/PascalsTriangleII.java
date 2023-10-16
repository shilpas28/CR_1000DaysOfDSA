//Leetcode
//119. Pascal's Triangle II
//Time complexity: O(N)
//Space complexity: O(N) 

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(getRow(rowIndex));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long temp = 1;
        for (int i = 1, up = rowIndex, down = 1; i <= rowIndex; i++, up--, down++) {
            temp = temp * up / down;
            ans.add((int) temp);
        }
        return ans;
    }
}
