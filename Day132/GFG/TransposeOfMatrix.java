//GFG
//Transpose of Matrix
//Time complexity: O(N^2)
//Space complexity: O(1)

public class TransposeOfMatrix {

    public static void main(String[] args) {
        int N = 4;
        int mat[][] = { { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 } };

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
        transpose(N, mat);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void transpose(int n, int a[][]) {
        for(int i=0; i<n ;i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int t=a[i][j]; a[i][j]=a[j][i]; a[j][i]=t;
            }
        }
    }
}
