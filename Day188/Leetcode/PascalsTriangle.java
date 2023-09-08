//Leetcode - Naive method
//118. Pascal's Triangle
//Time complexity: O(n*n*r) ~ O(n3), where n = number of rows, and r = column index.
//The row loop will run for approximately n times. And generating a row using the 
//naive approach of variation 2 takes O(n*r) time complexity.
//Space complexity: O(1). In this case, we are only using space to store the answer. 
//That is why space complexity can be still considered as O(1).

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {

        int numRows = 5;
        List<List<Integer>> ans = generate(numRows);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {

        int n = numRows;
        List<List<Integer>> ans = new ArrayList<>();
        // Store the entire Pascal's triangle:
        for (int row = 1; row <= n; row++) {
            List<Integer> tempLst = new ArrayList<>(); // temporary list
            for (int col = 1; col <= row; col++) {
                tempLst.add(nCr(row - 1, col - 1));
            }
            ans.add(tempLst);
        }
        return ans;
    }

    public static int nCr(int n, int r) {
        long res = 1;
        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }
}
