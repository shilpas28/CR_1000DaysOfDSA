//Leetcode
//118. Pascal's Triangle
//Time complexity: O(n2), where n = number of rows(given).
//We are generating a row for each single row. The number of rows is n. 
//And generating an entire row takes O(n) time complexity.
//Space complexity: O(1). In this case, we are only using space to store the answer. 
//That is why space complexity can still be considered as O(1).

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_2 {

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }

    public static List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> ans = new ArrayList<>();
        // store the entire pascal's triangle:
        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }

    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // inserting the 1st element
        // calculate the rest of the elements:
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }
}
