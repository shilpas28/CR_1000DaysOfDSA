//Leetcode
//1823. Find the Winner of the Circular Game - Recursion With Subproblems
//Time complexity: O(n), since there's n function calls (recursion)
//Space complexity: O(n), since there's n function calls (recursion)

public class FindTheWinnerOfTheCircularGame_2 {

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(findTheWinner(n, k));
    }

    public static int findTheWinner(int n, int k) {
        return recursion(n, k) + 1;
    }

    static int recursion(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (recursion(n - 1, k) + k) % n;
    }
}
