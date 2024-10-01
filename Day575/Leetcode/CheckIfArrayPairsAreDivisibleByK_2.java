//Leetcode
//1497. Check If Array Pairs Are Divisible by k
//Time complexity: O(N)
//Space complexity: O(k)

public class CheckIfArrayPairsAreDivisibleByK_2 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 };
        int k = 5;
        System.out.println(canArrange(arr, k));
    }

    public static boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for (int num : arr) {
            int remainder = (num % k + k) % k;
            freq[remainder]++;
        }

        if (freq[0] % 2 != 0)
            return false;
        for (int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i])
                return false;
        }
        return true;
    }
}
