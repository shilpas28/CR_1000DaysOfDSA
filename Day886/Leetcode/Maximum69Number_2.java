//Leetcode
//1323. Maximum 69 Number - Remainder Check
//Time complexity: O(digit)
//Space complexity: O(1)

public class Maximum69Number_2 {

    public static void main(String[] args) {
        int num = 9669;
        System.out.println(maximum69Number(num));
    }

    public static int maximum69Number(int num) {
        int numCopy = num;
        int indexFirstSix = -1;
        int currDigit = 0;

        while (numCopy > 0) {
            if (numCopy % 10 == 6)
                indexFirstSix = currDigit;
            numCopy /= 10;
            currDigit++;
        }

        return indexFirstSix == -1 ? num : num + 3 * (int) Math.pow(10, indexFirstSix);
    }
}
