//GFG
//Copy Set Bits in Range
//Time complexity: O(R-L)
//Space complexity: O(1)

public class CopySetBitsInRange {

    public static void main(String[] args) {
        int X = 44, Y = 3;
        int L = 1, R = 5;
        System.out.println(setSetBit(X, Y, L, R));
    }

    static int setSetBit(int x, int y, int l, int r) {
        // code here
        for (int i = l; i <= r; i++) {
            if ((y & (1 << (i - 1))) != 0)
                x = x | (1 << (i - 1));
        }
        return x;
    }
}
