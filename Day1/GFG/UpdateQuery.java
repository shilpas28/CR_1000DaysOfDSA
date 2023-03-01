//GFG - POTD
//Update Queries - Brute force method
//Time complexity: O(N^2)
//Space complexity:O(N);
import java.util.Arrays;

public class UpdateQuery {
    public static void main(String[] args) {
        int N = 3, Q = 2;
        int u[][] = { { 1, 3, 1 }, { 1, 3, 2 } };
        int[] result = updateQuery(N, Q, u);
        System.out.println(Arrays.toString(result));
    }

    public static int[] updateQuery(int N, int Q, int[][] U) {
        int res[] = new int[N];
        for (int i = 0; i < Q; i++) {
            for (int j = U[i][0]-1; j <= U[i][1]-1; j++) {
                res[j] = res[j] | U[i][2];
            }
        }
        return res;
    }
}
