//Leetcode
//1545. Find Kth Bit in Nth Binary String
//Time complexity: O(N)
//Space complexity: O(1) 

public class FindKthBitInNthBinaryString {

    public static void main(String[] args) {
        int n = 4, k = 11;
        System.out.println(findKthBit(n, k));
    }

    public static char findKthBit(int n, int k) {
        int count = 0, l = (1 << n) - 1;
        while (k > 1) {
            if (k == l / 2 + 1)
                return count % 2 == 0 ? '1' : '0';
            if (k > l / 2) {
                k = l + 1 - k;
                count++;
            }
            l /= 2;
        }
        return count % 2 == 0 ? '0' : '1';
    }
}
