//Leetcode
//3021. Alice and Bob Playing Flower Game
//Time complexity: O(1)
//Space complexity: O(1)

package Leetcode;

public class AliceAndBobPlayingFlowerGame {

    public static void main(String[] args) {
        int n = 3, m = 2;
        System.out.println(flowerGame(n, m));
    }

    public static long flowerGame(int n, int m) {
        // Step 1: Count odds and evens in range [1, n]
        long oddX = (n + 1) / 2;
        long evenX = n / 2;

        // Step 2: Count odds and evens in range [1, m]
        long oddY = (m + 1) / 2;
        long evenY = m / 2;

        // Step 3: Alice wins when x+y is odd
        // Case 1: x odd & y even
        // Case 2: x even & y odd

        // Step 4: Count total winning pairs
        return oddX * evenY + evenX * oddY;
    }
}
