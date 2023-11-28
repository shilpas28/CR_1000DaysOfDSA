//Leetcode
//2147. Number of Ways to Divide a Long Corridor
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class NumberOfWaysToDivideALongCorridor_3 {

    public static void main(String[] args) {
        String corridor = "SSPPSPS";
        System.out.println(numberOfWays(corridor));
    }

    static int MOD = 1_000_000_007;

    public static int numberOfWays(String corridor) {
        long ways = 1, seats = 0, plants = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                if (seats == 2) {
                    // multiply the counts of plants (+1) in between every 2 seats
                    ways = ways * (plants + 1) % MOD;
                    seats = plants = 0;
                }
                seats++;
                // only count plants after you've seen 2 seats (ignore in-between plants)
            } else if (seats == 2)
                plants++;
        }
        // ensure the last section has 2 seats i.e. the total number of seats is >=2 and even
        return seats == 2 ? (int) ways : 0;
    }
}
