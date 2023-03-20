//Leetcode
//605. Can Place Flowers
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int flowerbed[] = { 1, 0, 0, 0, 1 };
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int total = 0;
        for (int i = 0; i < flowerbed.length && total < n; i++) {
            if (flowerbed[i] == 0) {
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if (next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    total++;
                }
            }
        }

        return total == n;
    }
}
