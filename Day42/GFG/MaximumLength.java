//GFG
//Maximum Length
//Time complexity: O(a+b+c)
//Space complexity: O(1)

package GFG;

public class MaximumLength {

    public static void main(String[] args) {
        int a = 3, b = 3, c = 3;
        System.out.println(solve(a, b, c));
    }

    static int solve(int a, int b, int c) {
        // code here
        int max = Math.max(a, Math.max(b, c));
        int y;

        if (max == a)
            y = b + c;
        else if (max == b)
            y = c + a;
        else
            y = a + b;

        if (2 * (y + 1) >= max)
            return a + b + c;
        return -1;
    }
}
