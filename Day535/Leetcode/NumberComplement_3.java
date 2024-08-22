//Leetcode
//476. Number Complement - Bit Manipulation
//Time complexity: O(1)
//Space complexity: O(1)

public class NumberComplement_3 {

    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }

    public static int findComplement(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }
}
