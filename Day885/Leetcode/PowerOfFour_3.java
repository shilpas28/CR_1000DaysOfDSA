//Leetcode
//342. Power of Four - Bit Manipulation
//Time complexity: O(1) 
//Space complexity: O(1) 

public class PowerOfFour_3 {

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }

    public static boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;

        if ((lsb(n) % 2 == 0) && (n & (n - 1)) == 0) {
            return true;
        } else
            return false;
    }

    static int lsb(int n) {
        int p = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                return p - 1;
            }
            p++;
            n = n >> 1;
        }
        return -1;
    }
}
