//GFG
//Remove K Digits
//Time complexity: O(|S|)
//Space complexity: O(|S|) 

package GFG;

public class RemoveKDigits_2 {

    public static void main(String[] args) {
        String S = "149811";
        int K = 3;
        System.out.println(removeKdigits(S, K));
    }

    public static String removeKdigits(String S, int K) {
        // code here
        int n = S.length();
        if (K == n)
            return "0";

        char[] stack = new char[n];
        int top = -1;
        for (char digit : S.toCharArray()) {
            while (top >= 0 && K > 0 && stack[top] > digit) {
                top--;
                K--;
            }
            stack[++top] = digit;
        }
        while (K > 0) {
            top--;
            K--;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= top; i++)
            result.append(stack[i]);
        int startIndex = 0;
        while (startIndex < result.length() && result.charAt(startIndex) == '0')
            startIndex++;
        return (startIndex == result.length()) ? "0" : result.substring(startIndex);
    }
}
