//GFG
//Minimum Operations
//Time complexity: O(logN)
//Space complexity: O(1)

package GFG;

public class MinimumOperations {

    public static void main(String[] args) {
        int N = 8;
        System.out.println(minOperation(N));
    }

    public static int minOperation(int n) {
        // code here.
        int step = 0;
        while (n != 0) {
            if (n % 2 == 0)
                n = n / 2;
            else
                n = n - 1;
            step++;
        }
        return step;
    }
}
