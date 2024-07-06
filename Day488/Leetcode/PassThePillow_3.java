//Leetcode
//2582. Pass the Pillow
//Time complexity: O(1)
//Space complexity: O(1)

package Leetcode;

public class PassThePillow_3 {

    public static void main(String[] args) {
        int n = 4, time = 5;
        System.out.println(passThePillow(n, time));
    }

    public static int passThePillow(int n, int time) {
        return n - Math.abs(n - 1 - time % (n * 2 - 2));
    }
}
