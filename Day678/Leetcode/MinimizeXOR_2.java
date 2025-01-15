//Leetcode
//2429. Minimize XOR - Modularized Helper Functions
//Time complexity: O(32) - (constant time for 32-bit integers)
//Space complexity: O(1)

public class MinimizeXOR_2 {

    public static void main(String[] args) {
        int num1 = 3, num2 = 5;
        System.out.println(minimizeXor(num1, num2));
    }

    public static int minimizeXor(int num1, int num2) {
        int setBitsNum1 = countSetBits(num1);
        int setBitsNum2 = countSetBits(num2);

        if (setBitsNum1 == setBitsNum2)
            return num1;
        if (setBitsNum1 < setBitsNum2)
            return addSetBits(num1, setBitsNum2 - setBitsNum1);
        return removeSetBits(num1, setBitsNum1 - setBitsNum2);
    }

    static int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }

    static int addSetBits(int num, int bitsToAdd) {
        int bitPos = 0;
        while (bitsToAdd > 0) {
            while ((num >> bitPos & 1) == 1)
                bitPos++;
            num |= 1 << bitPos;
            bitsToAdd--;
        }
        return num;
    }

    static int removeSetBits(int num, int bitsToRemove) {
        while (bitsToRemove > 0) {
            num &= (num - 1);
            bitsToRemove--;
        }
        return num;
    }
}
