//GFG
//Sum of all substrings of a number
//Time complexity: O(N^2)
//Space complexity: O(1)

public class SumOfAllSubstringsOfANumber {

    public static void main(String[] args) {
        String s = "6759";
        System.out.println(sumSubstrings(s));
    }

    public static int sumSubstrings(String s) {
        // code here
        int res = 0;
        if (s == null || s.length() == 0)
            return res;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Integer num = Integer.parseInt(s.substring(i, j + 1));
                res += num;
            }
        }
        return res;
    }
}
