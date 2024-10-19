//Leetcode
//1545. Find Kth Bit in Nth Binary String
//Time complexity: O(1)
//Space complexity: O(1)

public class FindKthBitInNthBinaryString_3 {

    public static void main(String[] args) {
        int n = 4, k = 11;
        System.out.println(findKthBit(n, k));
    }

    public static char findKthBit(int n, int k) {
        return (char) ((k / (k & -k) >> 1 & 1) ^ (k & 1 ^ 1) + '0');
    }
}
