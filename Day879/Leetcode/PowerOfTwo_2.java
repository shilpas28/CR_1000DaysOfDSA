//Leetcode
//231. Power of Two
//Time complexity: O(logN)
//Space complexity: O(logN) or O(H) where H is height of recursive stack

public class PowerOfTwo_2 {

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        if (n == 1)
            return true;
        if (n % 2 == 1)
            return false;
        return (isPowerOfTwo(n / 2));
    }
}
