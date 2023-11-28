//Leetcode
//2147. Number of Ways to Divide a Long Corridor
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class NumberOfWaysToDivideALongCorridor_2 {

    public static void main(String[] args) {
        String corridor = "SSPPSPS";
        System.out.println(numberOfWays(corridor));
    }

    public static int numberOfWays(String corridor) {
        int x = 1; // 0 seat
        int y = 0; // 1 seat
        int z = 0; // 2 seats
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < corridor.length(); ++i)
            if (corridor.charAt(i) == 'S') {
                x = (x + z) % mod;
                z = y;
                y = x;
                x = 0;
            } else {
                x = (x + z) % mod;
            }
        return z;
    }
}
