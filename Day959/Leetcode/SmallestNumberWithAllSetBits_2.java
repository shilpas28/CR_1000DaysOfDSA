//Leetcode
//3370. Smallest Number With All Set Bits
//Time complexity: O(1)
//Space complexity: O(1) 

public class SmallestNumberWithAllSetBits_2 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(smallestNumber(n));
    }

    public static int smallestNumber(int n) {
        int b = (int) (Math.log(n) / Math.log(2)) + 1; // Calculate the number of bits
        return (1 << b) - 1; // Return 2^b - 1
    }
}
