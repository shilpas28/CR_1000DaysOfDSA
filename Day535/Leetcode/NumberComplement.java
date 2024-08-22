//Leetcode
//476. Number Complement
//Time complexity: O(logN) - Using Binary Number Range, Without Bit Manipulation
//Space complexity: O(1)

public class NumberComplement {

    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }

    public static int findComplement(int num) {
        int tmp = (int) (Math.pow(2, digits(num)) - 1);
        return tmp - num;
    }

    static int digits(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 2;
            count++;
        }
        return count;
    }
}
