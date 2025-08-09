//Leetcode
//231. Power of Two
//Time complexity: O(1)
//Space complexity: O(1)

public class PowerOfTwo_3 {

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        return n == Math.pow(2, Math.round(Math.log(n) / Math.log(2)));
    }
}
