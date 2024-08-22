//Leetcode
//476. Number Complement - Optimizing Previous Approach 
//Time complexity: O(1)
//Space complexity: O(1)

public class NumberComplement_2 {

    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }

    public static int findComplement(int num) {
        // Calculate the number of bits required to store the num
        long digits = (long) (Math.log(num) / Math.log(2)) + 1;
        // Calculate (2 ^ digits) - 1
        long tmp = (long) Math.pow(2, digits) - 1;
        // Subtract num from this value to get the complement
        return (int) tmp - num;
    }
}
