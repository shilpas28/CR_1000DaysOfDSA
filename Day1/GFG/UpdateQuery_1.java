//GFG - POTD
//Update Queries - Optimal solution
//Time complexity: O(N)
//Space complexity:O(N);
import java.util.Arrays;
public class UpdateQuery_1 {
    public static void main(String[] args) {
        int N = 3, Q = 2;
        int U[][] = { { 1, 3, 1 }, { 1, 3, 2 } };
        int[] result = updateQuery(N, Q, U);
        System.out.println(Arrays.toString(result));
    }

    public static int[] updateQuery(int N, int Q, int[][] U) {
        
        int prefix[][] = new int[N + 1][32];
        int ans[] = new int[N];

        for (int i = 0; i < Q; i++) {
            int l = U[i][0];
            int r = U[i][1];
            int x = U[i][2];
            int pos = 0; // starting from last bit - and then going left
            while (x > 0) {
                if ((x & 1) != 0) { // checking if set
                    prefix[l - 1][pos]++;
                    prefix[r][pos]--;
                }
                pos++;
                x = x / 2; // x>>=1;
            }
        }
        // add with prev num
        for (int i = 0; i < 32; i++) {
            for (int j = 1; j < N; j++) {
                prefix[j][i] += prefix[j - 1][i];
            }
        }
        // print
        for (int i = 0; i < N; i++) {
            int res = 0;
            for (int j = 0; j < 32; j++) {
                if (prefix[i][j] > 0) {
                    res += (1 << j); // n<<1 => n * 2^1
                }
            }
            ans[i] = res;
        }
        return ans;
    }
}
