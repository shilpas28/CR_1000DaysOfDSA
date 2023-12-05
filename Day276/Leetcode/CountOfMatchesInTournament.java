//Leetcode
//1688. Count of Matches in Tournament
//Time complexity: O(logN)
//Space complexity: O(logN)

package Leetcode;

public class CountOfMatchesInTournament {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(numberOfMatches(n));
    }

    public static int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        }
        return n / 2 + numberOfMatches(n / 2 + n % 2);
    }
}
