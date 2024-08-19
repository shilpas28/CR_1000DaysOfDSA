//Leetcode
//650. 2 Keys Keyboard - Prime Factorization
//Time complexity: O(sqrt(N))
//Space complexity: O(1)

public class TwoKeysKeyboard_4 {

    public static void main(String[] args) {
        int n = 3;
        TwoKeysKeyboard obj = new TwoKeysKeyboard();
        System.out.println(obj.minSteps(n));
    }

    public int minSteps(int n) {
        if (n == 1)
            return 0;

        int steps = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                steps += i;
                n /= i;
            }
        }
        if (n > 1) {
            steps += n;
        }
        return steps;
    }
}
