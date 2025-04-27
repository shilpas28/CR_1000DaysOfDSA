//GFG
//Multiply two strings
//Time complexity: O(n*m)
//Space complexity: O(n*m)

public class MultiplyTwoStrings {

    public static void main(String[] args) {
        String s1 = "0033", s2 = "2";
        System.out.println(multiplyStrings(s1, s2));
    }

    public static String multiplyStrings(String s1, String s2) {
        // code here.
        // Handle edge cases
        if (s1.equals("0") || s2.equals("0"))
            return "0";

        // Determine the sign of the result
        boolean isNegative = (s1.charAt(0) == '-' && s2.charAt(0) != '-')
                || (s1.charAt(0) != '-' && s2.charAt(0) == '-');

        // Remove leading zeros and signs
        s1 = s1.replaceFirst("^[-0]+", "");
        s2 = s2.replaceFirst("^[-0]+", "");

        // If either string becomes empty after removing leading zeros, return "0"
        if (s1.isEmpty() || s2.isEmpty())
            return "0";

        int n = s1.length(), m = s2.length();
        int[] result = new int[n + m];

        // Multiply each digit of s1 with each digit of s2
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }

        // Convert result array to string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        // Add sign if necessary
        return isNegative ? "-" + sb.toString() : sb.toString();
    }
}
