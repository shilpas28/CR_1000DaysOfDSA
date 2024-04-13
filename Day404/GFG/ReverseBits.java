//GFG
//Reverse Bits
//Time complexity: O(logN)
//Space complexity: O(1)

package GFG;

public class ReverseBits {

    public static void main(String[] args) {
        long x = 1;
        System.out.println(reversedBits(x));
    }

    static Long reversedBits(Long x) {
        // code here
        long ans = 0, i = 31;
        while (x != 0) {
            ans += (long) Math.pow(2, i) * (x & 1);
            x >>= 1;
            i--;
        }
        return ans;
    }
}
