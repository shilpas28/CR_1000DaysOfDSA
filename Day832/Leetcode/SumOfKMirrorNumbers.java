//Leetcode
//2081. Sum of k-Mirror Numbers - Brute Force - Not accepted as TLE 
//Time complexity: O(N*d)
//Space complexity: O(1)

public class SumOfKMirrorNumbers {

    public static void main(String[] args) {
        int k = 3, n = 7;
        System.out.println(kMirror(k, n));
    }

    public static long kMirror(int k, int n) {
        long res = 0;
        long cnt = 0;
        for (long i = 1; i < Long.MAX_VALUE; i++) {
            if (iskmirror(k, i) && iskmirror(10, i)) {
                res += i;
                cnt++;
                if (cnt == n) {
                    return res;
                }
            }
        }
        return res;
    }

    static boolean iskmirror(long k, long n) {
        long num = 0;
        long tmp = n;
        while (n != 0) {
            num = num * k + n % k;
            n = n / k;
        }
        return tmp == num;
    }
}
