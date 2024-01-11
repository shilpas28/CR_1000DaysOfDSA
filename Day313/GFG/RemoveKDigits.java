//GFG
//Remove K Digits
//Time complexity: O(|S|)
//Space complexity: O(|S|) 

package GFG;

import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {
        String S = "149811";
        int K = 3;
        System.out.println(removeKdigits(S, K));
    }

    public static String removeKdigits(String S, int K) {
        // code here
        int n = S.length();
        if (n == K) {
            return "0";
        }
        Stack<Character> store = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (K > 0 && !store.empty() && store.peek() > S.charAt(i)) {
                store.pop();
                K--;
            }
            store.push(S.charAt(i));
        }
        while (K > 0) {
            store.pop();
            K--;
        }
        StringBuilder ans = new StringBuilder();
        while (!store.empty()) {
            ans.append(store.pop());
        }
        ans.reverse();
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }
        if (i == ans.length()) {
            return "0";
        }
        return ans.substring(i);
    }
}
