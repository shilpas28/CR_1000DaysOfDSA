//Leetcode
//168. Excel Sheet Column Title
//Time complexity: O(No of digits)
//Space complexity: O(N)

package Leetcode;

public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        int columnNumber = 1;
        System.out.println(convertToTitle(columnNumber));
    }

    public static String convertToTitle(int columnNumber) {
        int n = columnNumber;
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            char tmp = (char) ((n % 26 == 0 ? 26 : n % 26) + 64);
            sb.append(tmp);
            n = (n % 26 == 0 ? n / 26 - 1 : n / 26);
        }
        return sb.reverse().toString();
    }
}
