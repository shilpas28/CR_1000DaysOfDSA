//Leetcode
//1688. Count of Matches in Tournament
//Time complexity: O(logN)
//Space complexity: O(1) 

package Leetcode;

public class CountOfMatchesInTournament_2 {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(numberOfMatches(n));
    }

    public static int numberOfMatches(int n) {
        int matches = 0;
        while (n > 1) {
            matches += n / 2;
            n = (n + 1) / 2;
        }
        return matches;
    }
}
