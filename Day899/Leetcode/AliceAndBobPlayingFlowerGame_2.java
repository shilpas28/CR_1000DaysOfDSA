//Leetcode
//3021. Alice and Bob Playing Flower Game
//Time complexity: O(1)
//Space complexity: O(1)

package Leetcode;

public class AliceAndBobPlayingFlowerGame_2 {

    public static void main(String[] args) {
        int n = 3, m = 2;
        System.out.println(flowerGame(n, m));
    }

    public static long flowerGame(int n, int m) {
        long a = m;
        long b = n;
        long s = a * b;
        return s / 2;
    }
}
