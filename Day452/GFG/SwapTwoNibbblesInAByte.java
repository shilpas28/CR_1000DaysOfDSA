//GFG
//Swap two nibbles in a byte
//Time complexity: O(1)
//Space complexity: O(1)

public class SwapTwoNibbblesInAByte {

    public static void main(String[] args) {
        int n = 100;
        System.out.println(swapNibbles(n));
    }

    static int swapNibbles(int n) {
        // code here
        return (n & 0x0F) << 4 | (n >> 4);
    }
}
