//GFG
//Rohan's Love for Matrix
//Time complexity: O(N)
//Space complexity: O(1)

public class RohansLoveForMatrix {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(firstElement(n));
    }

    static int firstElement(int n) {
        // code here
        if (n == 1 || n == 2)
            return 1;
        int a = 1, b = 1, ans = 0, mod = 1000000007;
        for (int i = 3; i <= n; i++) {
            ans = (a + b) % mod;
            a = b;
            b = ans;
        }
        return ans;
    }
}
