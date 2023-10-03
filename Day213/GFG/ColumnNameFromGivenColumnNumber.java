//GFG
//Column name from a given column number
//Time complexity: O(LogN)
//Space complexity: O(1)

public class ColumnNameFromGivenColumnNumber {

    public static void main(String[] args) {
        long N = 28;
        System.out.println(colName(N));
    }

    static String colName(long n) {
        // your code here
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append((char) ('A' + n % 26));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}
