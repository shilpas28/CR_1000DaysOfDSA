//GFG
//Median in a row-wise sorted Matrix
//Time complexity: O(n log m * log(maxVal – minVal))
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.Collections;

public class MedianInARowWiseSortedMatrix_3 {

    public static void main(String[] args) {
        int mat[][] = { { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 } };
        System.out.println(median(mat));
    }

    public static int median(int[][] mat) {
        // code here
        // traversing matrix with O(n*m)
        int row = mat.length;
        int col = mat[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0, r = 0, c = 0; i < row * col; i++) {
            list.add(mat[r][c]);
            c++;
            if (c == col) {
                c = 0;
                r++;
            }
        }
        Collections.sort(list);
        return list.get(list.size() / 2);
    }
}
