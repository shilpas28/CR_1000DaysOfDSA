//GFG
//First non-repeating character in a stream -  Queue to track first non repeating character
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterInAStream {

    public static void main(String[] args) {
        String A = "aabc";
        System.out.println(FirstNonRepeating(A));
    }

    public static String FirstNonRepeating(String A) {
        // code here
        StringBuilder ans = new StringBuilder();
        int n = A.length();
        int arr[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            arr[ch - 'a']++;
            q.add(ch);
            while (!q.isEmpty()) {
                if (arr[q.peek() - 'a'] == 1) {
                    ans.append(q.peek());
                    break;
                } else
                    q.poll();
            }
            if (q.isEmpty())
                ans.append('#');
        }
        return ans.toString();
    }
}
