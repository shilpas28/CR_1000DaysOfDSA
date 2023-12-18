//GFG
//Game of XOR
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class GameOfXOR {

    public static void main(String[] args) {
        int N = 3;
        int[] A = { 1, 2, 3 };
        System.out.println(gameOfXor(N, A));
    }

    static int gameOfXor(int N, int[] A) {
        // code here
        int x = 0;

        for (int i = 0; i < N; i++) {
            int y = (i + 1) * (N - i);
            if ((y & 1) == 1)
                x ^= A[i];
        }
        return x;
    }
}
