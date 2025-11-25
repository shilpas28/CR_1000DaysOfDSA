//Leetcode
//1015. Smallest Integer Divisible by K
//Time complexity: O(k)
//Space complexity: O(1)

public class SmallestIntegerDivisibleByK_2 {

    public static void main(String[] args) {
        int k = 1;
        System.out.println(smallestRepunitDivByK(k));
    }

    public static int smallestRepunitDivByK(int k) {
        // if (k % 2 == 0 || k % 5 == 0) return -1;  // this trick may save a little time
        int n = 0;
        for (int i = 0; i < k; i++) { // at most k times, because 0 <= remainder < k
            n = (n * 10 + 1) % k; // we only focus on whether to divide, so we only need to keep the remainder.
            if (n == 0) {
                return i + 1; // i started from 0, so before return it should be added 1

                    }}
        return -1; // If it had not stop after k transfers, it must enter the loop, and it won't stop.
    }
}
