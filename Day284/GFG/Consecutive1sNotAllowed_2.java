//GFG
//Consecutive 1's not allowed
//Time complexity: O(N)
//Space complexity: O(N) 

package GFG;

public class Consecutive1sNotAllowed_2 {

    public static void main(String[] args) {
        int N = 3;
        System.out.println(countStrings(N));
    }

    static long countStrings(int n) {
        // code here
        if (n == 1)
            return 2;
        long one = 1, zero = 1, total = one + zero;

        while (n-- > 1) {
            one = zero;
            zero = total;
            total = (one + zero) % 1000000007;
        }

        return total % 1000000007;
    }
}
