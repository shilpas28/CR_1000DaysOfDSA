//GFG
//Minimum Number
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class MinimumNumber {

    public static void main(String[] args) {
        int n = 3;
        int[] arr = { 3, 2, 4 };
        System.out.println(minimumNumber(n, arr));
    }

    public static int minimumNumber(int n, int[] arr) {
        // code here
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = gcd(ans, arr[i]);
        }
        return ans;
    }

    public static int gcd(int a, int b) // log(min(a,b))
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
