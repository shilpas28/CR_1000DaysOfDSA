//Leetcode
//2566. Maximum Difference by Remapping a Digit
//Time complexity: O(lognum)
//Space complexity: O(lognum)

public class MaximumDifferenceByRemappingADigit_2 {

    public static void main(String[] args) {
        int num = 11891;
        System.out.println(minMaxDifference(num));
    }

    public static int minMaxDifference(int num) {
        String s = Integer.toString(num);
        String t = s;
        int pos = 0;
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }
        t = t.replace(t.charAt(0), '0');
        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}
