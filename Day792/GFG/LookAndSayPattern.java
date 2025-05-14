//GFG
//Look and Say Pattern
//Time complexity: O(2^N)
//Space complexity: O(2^N)

public class LookAndSayPattern {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
        // code here
        if (n <= 0)
            return "";
        String result = "1"; // Base case: first term
        for (int i = 1; i < n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            char prevChar = result.charAt(0);
            // Start from second character
            for (int j = 1; j < result.length(); j++) {
                char currChar = result.charAt(j);
                if (currChar == prevChar) {
                    count++;
                } else {
                    current.append(count).append(prevChar);
                    count = 1;
                    prevChar = currChar;
                }
            }
            // Append the last group
            current.append(count).append(prevChar);
            // Update result for the next iteration
            result = current.toString();
        }
        return result;
    }
}
