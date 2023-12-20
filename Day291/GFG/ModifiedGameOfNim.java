//GFG
//Modified Game of Nim
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class ModifiedGameOfNim {

    public static void main(String[] args) {
        int n = 3;
        int[] A = { 3, 3, 2 };
        System.out.println(findWinner(n, A));
    }

    static int findWinner(int n, int A[]) {
        // code here
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= A[i];
        }
        if (ans == 0 || n % 2 == 0) {
            return 1;
        }
        return 2;
    }
}
