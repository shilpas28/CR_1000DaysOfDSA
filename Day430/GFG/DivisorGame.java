//GFG
//Divisor Game
//Time complexity: O(1)
//Space complexity: O(1)

package GFG;

public class DivisorGame {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(divisorGame(n));
    }

    public static boolean divisorGame(int n) {
        // code here
        return n % 2 == 0;
    }
}
