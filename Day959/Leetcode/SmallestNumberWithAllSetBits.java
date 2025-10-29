//Leetcode
//3370. Smallest Number With All Set Bits
//Time complexity: O(logN)
//Space complexity: O(1)

public class SmallestNumberWithAllSetBits {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(smallestNumber(n));
    }

    public static int smallestNumber(int n) {
        int res = 1;
        while (res < n)
            res = res * 2 + 1;
        return res;
    }
}
