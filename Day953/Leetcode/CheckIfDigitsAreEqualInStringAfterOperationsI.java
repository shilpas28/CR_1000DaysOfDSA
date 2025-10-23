//Leetcode
//3461. Check If Digits Are Equal in String After Operations I
//Time complexity: O(N^2)
//Space complexity: O(N) 

public class CheckIfDigitsAreEqualInStringAfterOperationsI {

    public static void main(String[] args) {
        String s = "3902";
        System.out.println(hasSameDigits(s));
    }

    public static boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder next_s = new StringBuilder();
            for (int i = 0; i < s.length() - 1; ++i) {
                int d1 = s.charAt(i) - '0';
                int d2 = s.charAt(i + 1) - '0';
                int sum = (d1 + d2) % 10;
                next_s.append(sum);
            }
            s = next_s.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}
