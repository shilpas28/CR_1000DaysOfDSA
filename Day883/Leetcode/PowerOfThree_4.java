//Leetcode
//326. Power of Three
//Time complexity: O(1)
//Space complexity: O(1) 

public class PowerOfThree_4 {

    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOfThree(n));
    }

    public static boolean isPowerOfThree(int n) {
        return Math.log10(n) / Math.log10(3) % 1 == 0;
    }
}
