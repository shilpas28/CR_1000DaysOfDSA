//GFG
//Recursive sequence
//Time complexity: O(N^2)
//Space complexity: O(1)

public class RecursiveSequence_2 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(sequence(n));
    }

    static long sequence(int n) {
        // code here
        long mod = 1000000007;
        long sum = 0;
        long count = 1;
        for (int i = 1; i <= n; i++) {
            long mul = 1;
            for (int j = 1; j <= i; j++) {
                mul = (mul * count) % mod;
                count++;
            }
            sum = (sum + mul) % mod;
        }
        return sum % mod;
    }
}
