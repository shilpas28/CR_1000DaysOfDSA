//Leetcode
//1323. Maximum 69 Number - String Conversion
//Time complexity: O(digit)
//Space complexity: O(digit)

public class Maximum69Number_4 {

    public static void main(String[] args) {
        int num = 9669;
        System.out.println(maximum69Number(num));
    }

    public static int maximum69Number(int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }
}
