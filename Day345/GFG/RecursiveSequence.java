//GFG
//Recursive sequence
//Time complexity: O(N^2)
//Space complexity: O(1)

public class RecursiveSequence {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(sequence(n));
    }

    static long sequence(int n) {
        // code here
        long ans = 1, mod = 1000000007, temp = 2;
        int i = 2;
        while (i <= n) {
            int j = i;
            long temp2 = 1;
            while (j != 0) {
                temp2 *= temp;
                temp2 %= mod;
                temp++;
                j--;
            }
            i++;
            ans += temp2;
            ans %= mod;
        }
        return ans;
    }
}
