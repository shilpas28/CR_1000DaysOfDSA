//GFG
//Minimum K Consecutive Bit Flips
//Time complexity: O(N)
//Space complexity: O(k) 

public class MinimumKConsecutiveBitFlips {

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1 };
        int k = 2;
        System.out.println(kBitFlips(arr, k));
    }

    public static int kBitFlips(int[] arr, int k) {
        // code here
        int n = arr.length;
        int flips = 0;
        int flip = 0;
        int[] isFlipped = new int[n];

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flip ^= isFlipped[i - k];
            }
            if ((arr[i] ^ flip) == 0) {
                if (i + k > n)
                    return -1;
                isFlipped[i] = 1;
                flip ^= 1;
                flips++;
            }
        }
        return flips;
    }
}
