//GFG
//Matchsticks Game
//Time complexity: O(1)
//Space complexity: O(1)

package GFG;

public class MatchsticksGame {

    public static void main(String[] args) {
        long N = 48;
        System.out.println(matchGame(N));
    }

    static int matchGame(Long N) {
        // code here
        if (N % 5 == 0)
            return -1;
        return (int) (N % 5);
    }
}
