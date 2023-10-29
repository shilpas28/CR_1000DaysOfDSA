//GFG
//Check whether K-th bit is set or not
//Time complexity: O(1)
//Space complexity: O(1)

package GFG;

public class CheckWhetherKthBitIsSetOrNot {

    public static void main(String[] args) {
        int N = 4, K = 2;
        System.out.println(checkKthBit(N, K));
    }

    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k) {
        // Your code here
        int mask = 1;
        mask = mask << k;
        return ((mask & n) >> k) == 1;
    }
}
