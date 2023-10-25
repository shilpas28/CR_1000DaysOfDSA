//Leetcode
//779. K-th Symbol in Grammar - Recursive Approach
//Time complexity: O(N) - The time complexity is O(N) as there is a single recursive call for every level of N.
//Space complexity: O(1) - The space complexity is also O(N) due to the stack space used by the recursive calls.

package Leetcode;

public class KthSymbolInGrammar {

    public static void main(String[] args) {
        int n = 1, k = 1;
        System.out.println(kthGrammar(n, k));
    }

    public static int kthGrammar(int n, int k) {
        if (n == 1)
            return 0;
        if (k % 2 == 0) {
            if (kthGrammar(n - 1, k / 2) == 0)
                return 1;
            else
                return 0;
        } else {
            if (kthGrammar(n - 1, (k + 1) / 2) == 0)
                return 0;
            else
                return 1;
        }
    }
}
