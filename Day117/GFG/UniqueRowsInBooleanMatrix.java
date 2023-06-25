//GFG
//Unique rows in boolean matrix
//Time complexity: O(row * col)
//Space complexity: O(row * col)

package GFG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class UniqueRowsInBooleanMatrix {

    public static void main(String[] args) {
        int row = 3, col = 4;
        int M[][] = { { 1, 1, 0, 1 }, { 1, 0, 0, 1 }, { 1, 1, 0, 1 } };
        System.out.println(uniqueRow(M, row, col));
    }

    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c) {
        // add code here.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set =new LinkedHashSet<>();
        for(int i=0; i<r; i++)
        {
            ArrayList<Integer> curr = new ArrayList<>();
            for(int j=0; j<c; j++)
            {
                curr.add(a[i][j]);
            }
            if(!set.contains(curr))
            set.add(curr);
        }
        for(ArrayList<Integer> x:  set)
        ans.add(x);
        return ans;
    }
}
