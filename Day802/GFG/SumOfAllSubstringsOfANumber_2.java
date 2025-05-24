//GFG
//Sum of all substrings of a number
//Time complexity: O(N)
//Space complexity: O(1)

public class SumOfAllSubstringsOfANumber_2 {

    public static void main(String[] args) {
        String s = "6759";
        System.out.println(sumSubstrings(s));
    }

    public static int sumSubstrings(String s) {
        // code here
        int n = s.length();
        int result = 0;
        int prev = 0;

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            prev = prev * 10 + (i + 1) * digit;
            result += prev;
        }

        return result;
    }
}
