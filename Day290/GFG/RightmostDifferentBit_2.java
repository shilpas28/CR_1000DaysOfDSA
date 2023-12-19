//GFG
//Rightmost different bit
//Time complexity: O(max(log M, log N))
//Space complexity: O(1)

package GFG;

public class RightmostDifferentBit_2 {

    public static void main(String[] args) {
        int M = 11, N = 9;
        System.out.println(posOfRightMostDiffBit(M, N));
    }

    // Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n) {
        // Your code here
        int num = m^n;
        int cnt = 0;
        while (num > 0) {
            cnt++;
            if ((num & 1) == 1)
                return cnt;

            num = num / 2; // n>>1;
        }
        return -1;
    }
}
