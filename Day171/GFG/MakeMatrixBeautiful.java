//GFG
//Make Matrix Beautiful
//Time complexity: O(N^2)
//Space complexity: O(N)

public class MakeMatrixBeautiful {

    public static void main(String[] args) {
        int N = 2;
        int matrix[][] = { { 1, 2 },
                { 3, 4 } };
        System.out.println(findMinOperation(N, matrix));
    }

    public static int findMinOperation(int N, int[][] matrix) {
        // code here
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum = sum + matrix[i][j];
            }
        }
        int rs = 0;
        int cs = 0;
        for (int i = 0; i < N; i++) {
            int a = 0;
            for (int j = 0; j < N; j++) {
                a = a + matrix[i][j];
            }
            rs = Math.max(rs, a);

            int b = 0;
            for (int j = 0; j < N; j++) {
                b = b + matrix[j][i];
            }
            cs = Math.max(cs, b);
        }
        int max = Math.max(cs, rs);
        return max * N - sum;
    }
}
