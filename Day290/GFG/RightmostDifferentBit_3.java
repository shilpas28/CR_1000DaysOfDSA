//GFG
//Rightmost different bit
//Time complexity: O(max(log M, log N))
//Space complexity: O(1)

package GFG;

public class RightmostDifferentBit_3 {

    public static void main(String[] args) {
        int M = 11, N = 9;
        System.out.println(posOfRightMostDiffBit(M, N));
    }

    // Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n) {
        // Your code here
        int num = m ^ n;
        int res = num & -num;
        int ans = (int) (Math.log(res) / Math.log(2));

        return ans + 1 > 0 ? ans + 1 : -1;
    }
}
