//GFG
//Implement Pow - Binary Exponentiation
//Time complexity: O(logN)
//Space complexity: O(1)

public class ImplementPow_2 {

    public static void main(String[] args) {
        double b = 3.00000;
        int e = 5;
        System.out.println(power(b, e));
    }

    static double power(double b, int e) {
        // code here
        double ans = 1.0;
        long nn = e;
        if (nn < 0)
            nn = -1 * nn;
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * b;
                nn = nn - 1;
            } else {
                b = b * b;
                nn = nn / 2;
            }
        }
        if (e < 0)
            ans = (double) (1.0) / (double) (ans);
        return ans;
    }
}
