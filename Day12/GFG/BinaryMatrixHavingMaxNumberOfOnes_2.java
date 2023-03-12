//GFG - Most optimal solution
//Binary matrix having maximum number of 1s
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class BinaryMatrixHavingMaxNumberOfOnes_2 {

    public static void main(String[] args) {
        int mat[][] = {{0,0,1},{0,1,1},{0,0,0}};
        System.out.println(Arrays.toString(findMaxRow(mat,3)));
    }

    public static int[] findMaxRow(int mat[][], int N) {
        // code here
        int row=0; int j=N-1; int res[]= new int[2];
        for(int i=0; i<N; i++)
        {
           while(j>=0 && mat[i][j]==1)
            {
                row=i;
                j--;
            }
        }
        
       res[0] = row;
       res[1] = N-j-1;
       return res;
    }
}
