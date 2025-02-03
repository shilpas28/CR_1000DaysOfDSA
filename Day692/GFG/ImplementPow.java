//GFG Method 1
//Implement Pow - Brute Force (Not accepted by GFG)
//Time complexity: O(N)
//Space complexity: O(1) 

public class ImplementPow {

    public static void main(String[] args) {
        double b = 3.00000;
        int e = 5;
        System.out.println(power(b, e));
    }

    static double power(double b, int e) {
        // code here
        double ans = 1.0;
        for (int i = 0; i < e; i++) {
            ans = ans * b;
        }
        return ans;
    }
}
