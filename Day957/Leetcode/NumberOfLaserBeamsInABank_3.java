//Leetcode
//2125. Number of Laser Beams in a Bank
//Time complexity: O(m * n), where m is the number of rows and n is the number of columns in the bank. The solution iterates 
//through each row and calculates the count of security devices in that row.
//Space complexity: O(1), as the space used is constant, and no additional data structures are used.

public class NumberOfLaserBeamsInABank_3 {

    public static void main(String[] args) {
        String[] bank = { "011001", "000000", "010100", "001000" };
        System.out.println(numberOfBeams(bank));
    }

    public static int numberOfBeams(String[] bank) {
        int prevRowCount = 0;
        int total = 0;

        for (String row : bank) {
            int curRowCount = calc(row);
            if (curRowCount == 0)
                continue;

            total += curRowCount * prevRowCount;
            prevRowCount = curRowCount;
        }
        return total;
    }

    static int calc(String s) {
        int count = 0;
        for (char c : s.toCharArray())
            count += c - '0';

        return count;
    }
}
