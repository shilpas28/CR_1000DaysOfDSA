//Leetcode
//1688. Count of Matches in Tournament
//Time complexity: O(1)
//Space complexity: O(1)

package Leetcode;

public class CountOfMatchesInTournament_3 {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(numberOfMatches(n));
    }

    public static int numberOfMatches(int n) {
        return n - 1;
    }
}
