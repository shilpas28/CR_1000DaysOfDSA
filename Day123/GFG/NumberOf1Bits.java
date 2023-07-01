//GFG
//Number Of 1 bits
//Time complexity: O(LogN)
//Space complexity: O(1)

package GFG;

public class NumberOf1Bits {

    public static void main(String[] args) {
        int N = 6;
        System.out.println(setBits(N));
    }

    static int setBits(int N) {
        // code here
        int setBits = 0;
        while (N > 0) {
            N = N & (N - 1);
            setBits++;
        }
        return setBits;
    }
}
