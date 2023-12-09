//GFG
//Smith Number
//Time complexity: O(n * log(n))
//Space complexity: O(n)

package GFG;

public class SmithNumber {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(smithNum(n));
    }

    static int smithNum(int n) {
        // code here
        int sum = 0, k = n, temp = digitsum(n);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                sum += digitsum(i);
                n /= i;
            }
        }
        if (n > 1 && n != k) {
            sum += digitsum(n);
        }
        return sum == temp ? 1 : 0;
    }

    static int digitsum(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}
