//Leetcode - Not accepted as TLE
//1155. Number of Dice Rolls With Target Sum - Brute Force(Recursion)
//Time complexity: O(n ^ target)
//Space complexity: O(n ^ target) 

package Leetcode;

public class NumberOfDiceRollsWithTargetSum {

    public static void main(String[] args) {
        int n = 2, k = 6, target = 7;
        System.out.println(numRollsToTarget(n, k, target));
    }

    static int mod = (int) Math.pow(10, 9) + 7; // mod initialisation

    public static int numRollsToTarget(int n, int k, int target) {
        if (target == 0 && n == 0) // if we hit a valid case, return 1
            return 1;
        if (target < 0 || n == 0) // if we hit an invalid case, return count as 0
            return 0;
        int count = 0; // initial count set to zero
        for (int i = 1; i <= k; i++) { // iteration because we have dices face value from 1 to k.
            count = (count + numRollsToTarget(n - 1, k, target - i) % mod) % mod; // magic function based on faith. mod
                                                                                  // is as per question.
        }
        return count; // return count.
    }
}
