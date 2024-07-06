//Leetcode
//2582. Pass the Pillow
//Time complexity: O(1)
//Space complexity: O(1)

package Leetcode;

public class PassThePillow_2 {

    public static void main(String[] args) {
        int n = 4, time = 5;
        System.out.println(passThePillow(n, time));
    }

    public static int passThePillow(int n, int time) {
        int rounds = time / (n - 1); // how many rounds have we passed back and forth
        int k = time % (n - 1); // index starting from left or right at the last round
        return rounds % 2 == 0 ? k + 1 : n - k;
    }
}
