//Leetcode - slightly easier solution 
//168. Excel Sheet Column Title
//Time complexity: O(No of digits)
//Space complexity: O(N)

package Leetcode;

public class ExcelSheetColumnTitle_2 {

    public static void main(String[] args) {
        int columnNumber = 1;
        System.out.println(convertToTitle(columnNumber));
    }

    public static String convertToTitle(int columnNumber) {
        int n = columnNumber;
        String res = "";
        while (n != 0) {
            char ch = (char) ((n - 1) % 26 + 65);
            n = (n - 1) / 26;
            res = ch + res;
        }
        return res;
    }
}
