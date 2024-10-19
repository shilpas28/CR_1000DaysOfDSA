//Leetcode
//1545. Find Kth Bit in Nth Binary String
//Time complexity: O(N)
//Space complexity:O(1)

public class FindKthBitInNthBinaryString_2 {

    public static void main(String[] args) {
        int n = 4, k = 11;
        System.out.println(findKthBit(n, k));
    }

    public static char findKthBit(int n, int k) {
        int flip = 0, l = (1 << n) - 1;
        while (k > 1) {
            if (k == l / 2 + 1)
                return flip == 0 ? '1' : '0';
            if (k > l / 2) {
                k = l + 1 - k;
                flip ^= 1;
            }
            l /= 2;
        }
        return flip == 0 ? '0' : '1';
    }
}
