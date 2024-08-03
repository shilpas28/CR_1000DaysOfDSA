//Leetcode
//1460. Make Two Arrays Equal by Reversing Subarrays - Prime Factor Signature
//Time complexity: O(N)
//Space complexity: O(M) where M is MAX_VALUE

public class MakeTwoArraysEqualByReversingSubarrays_4 {

    public static void main(String[] args) {
        int[] target = { 1, 2, 3, 4 };
        int[] arr = { 2, 4, 1, 3 };
        System.out.println(canBeEqual(target, arr));
    }

    static final int MAX_VALUE = 1000;
    static final int[] PRIMES = generatePrimes(MAX_VALUE);

    public static boolean canBeEqual(int[] target, int[] arr) {
        long signatureTarget = 1;
        long signatureArr = 1;

        for (int i = 0; i < target.length; i++) {
            signatureTarget *= PRIMES[target[i]];
            signatureArr *= PRIMES[arr[i]];
        }
        return signatureTarget == signatureArr;
    }

    static int[] generatePrimes(int n) {
        int[] primes = new int[n + 1];
        primes[1] = 2; // Start with 2 as the first prime

        int count = 1;
        for (int num = 3; count < n; num += 2) {
            if (isPrime(num))
                primes[++count] = num;
        }
        return primes;
    }

    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
}
