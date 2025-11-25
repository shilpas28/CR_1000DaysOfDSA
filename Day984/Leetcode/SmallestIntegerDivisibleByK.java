//Leetcode
//1015. Smallest Integer Divisible by K
//Time complexity: O(k)
//Space complexity: O(k)

public class SmallestIntegerDivisibleByK {

    public static void main(String[] args) {
        int k = 1;
        System.out.println(smallestRepunitDivByK(k));
    }

    public static int smallestRepunitDivByK(int k) {
        // if (k % 2 == 0 || k % 5 == 0) return -1;  // this trick may save a little time
        boolean[] hit = new boolean[k];
        int n = 0, ans = 0;
        while (true) { // at most k times, because 0 <= remainder < k
            ++ans;
            n = (n * 10 + 1) % k; // we only focus on whether to divide, so we only need to keep the remainder.
            if (n == 0) {
                return ans; // can be divisible

                        }if (hit[n]) {
                return -1; // the remainder of the division repeats, so it starts to loop that means it cannot be divisible.

                        }hit[n] = true;
        }
    }
}
