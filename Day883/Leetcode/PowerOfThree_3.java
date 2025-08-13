//Leetcode
//326. Power of Three
//Time complexity: O(1)
//Space complexity: O(1) 

public class PowerOfThree_3 {

    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOfThree(n));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;

        return n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }
}
