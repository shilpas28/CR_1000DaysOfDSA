//GFG
//Sequence of Sequence
//Time complexity: O(m*n)
//Space complexity: O(h) - space for recursive stack

package GFG;

public class SequenceOfSequence {

    public static void main(String[] args) {
        int m = 10, n = 4;
        System.out.println(numberSequence(m, n));
    }

    static int numberSequence(int m, int n) {
        // code here
        if (m < n)
            return 0;
        if (n == 0)
            return 1;
        return numberSequence(m / 2, n - 1) + numberSequence(m - 1, n);
    }
}
