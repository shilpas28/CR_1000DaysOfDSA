//GFG
//Rightmost different bit
//Time complexity: O(max(log M, log N))
//Space complexity: O(1)

package GFG;

public class RightmostDifferentBit {

    public static void main(String[] args) {
        int M = 11, N = 9;
        System.out.println(posOfRightMostDiffBit(M, N));
    }

    // Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n) {
        // Your code here
        if (m == n)
            return -1;
        int pos = 1;
        int x = m ^ n;
        while ((x & 1) != 1) {
            pos++;
            x /= 2;
        }
        return pos;
    }
}
