//GFG
//Game of XOR
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class GameOfXOR_2 {

    public static void main(String[] args) {
        int N = 3;
        int[] A = { 1, 2, 3 };
        System.out.println(gameOfXor(N, A));
    }

    static int gameOfXor(int N, int[] A) {
        // code here
        if (N % 2 == 0) {
            return 0;
        }
        int final_xor = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                final_xor ^= A[i];
            }
        }
        return final_xor;
    }
}
