//GFG
//Decode the string
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Stack;

public class DecodeTheString {

    public static void main(String[] args) {
        String s = "3[b2[ca]]";
        System.out.println(decodeString(s));
    }

    static String decodeString(String s) {
        // code here
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        char[] arr = s.toCharArray();
        int i = 0, num = 0;
        String curr = "";
        while (i < s.length()) {
            if (Character.isDigit(arr[i])) {
                num = 0;
                while (Character.isDigit(arr[i])) {
                    num = num * 10 + (arr[i] - '0');
                    i++;
                }
                count.push(num);
            } else if (arr[i] == '[') {
                result.add(curr);
                curr = "";
                i++;
            } else if (arr[i] == ']') {
                int n = count.pop();
                StringBuilder sb = new StringBuilder(result.pop());
                for (int j = 0; j < n; j++) {
                    sb.append(curr);
                }
                curr = sb.toString();
                i++;
            } else {
                curr += arr[i];
                i++;
            }
        }
        return curr;
    }
}
