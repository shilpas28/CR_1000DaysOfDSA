//GFG
//Bleak Numbers
//Time complexity: O(log(n) * log(n))
//Space complexity: O(1)

public class BleakNumbers {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(is_bleak(n));
    }

    public static int is_bleak(int n) {
        // Code here
        for (int i = n - 30; i <= n; i++) {
            if (i + count_set_bits(i) == n)
                return 0;
        }
        return 1;
    }

    static int count_set_bits(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1);
            n = n / 2; // n=n>>2;
        }
        return cnt;
    }
}
