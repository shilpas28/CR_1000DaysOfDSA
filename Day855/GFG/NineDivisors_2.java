//GFG
//Nine Divisors
//Time complexity: O(sqrt(n) * log(log(sqrt(n))))
//Space complexity: O(sqrt(n))

public class NineDivisors_2 {

    public static void main(String[] args) {
        int n = 100;
        System.out.println(countNumbers(n));
    }

    public static int countNumbers(int n) {
        // code here
        if (n < 36)
            return 0;
        int i = 6;
        int ans = 0;
        while ((i * i) <= n) {
            if (count(i) == 9) {
                ans++;
            }
            i++;
        }
        return ans;
    }

    public static int count(int n) {
        int i = 2;
        int ans = 3;
        int num = n * n;
        for (int j = i; j < n; j++) {
            if (num % j == 0)
                ans += 2;
            if (ans > 9)
                return ans;
        }
        return ans;
    }
}
