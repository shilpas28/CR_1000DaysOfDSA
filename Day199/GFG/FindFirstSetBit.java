//GFG
//Find first set bit
//Time complexity: O(logN)
//Space complexity: O(1) 

package GFG;

public class FindFirstSetBit {

    public static void main(String[] args) {
        int N = 12;
        System.out.println(getFirstSetBit(N));
    }

    // Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n) {
        // Your code here
        if (n == 0)
            return 0;
        int i = 1;
        while (n > 0 && n % 2 == 0) {
            n = n / 2;
            i++;
        }
        return i;
    }
}
