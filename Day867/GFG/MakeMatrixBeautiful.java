//GFG
//Make Matrix Beautiful
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class MakeMatrixBeautiful {

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3 }, { 4, 2, 3 }, { 3, 2, 1 } };
        System.out.println(balanceSums(mat));
    }

    public static int balanceSums(int[][] mat) {
        // code here
        int sum = 0;
        int N = mat.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum = sum + mat[i][j];
            }
        }
        int rs = 0;
        int cs = 0;
        for (int i = 0; i < N; i++) {
            int a = 0;
            for (int j = 0; j < N; j++) {
                a = a + mat[i][j];
            }
            rs = Math.max(rs, a);

            int b = 0;
            for (int j = 0; j < N; j++) {
                b = b + mat[j][i];
            }
            cs = Math.max(cs, b);
        }
        int max = Math.max(cs, rs);
        return max * N - sum;
    }
}
