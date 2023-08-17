//GFG
//Next Smallest Palindrome
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.Vector;

public class NextSmallestPalindrome {

    public static void main(String[] args) {
        int N = 11;
        int Num[] = { 9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2 };
        System.out.println(generateNextPalindrome(Num, N));

    }

    static Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
        Vector<Integer> ans = new Vector<>();
        int i, j, carry, solved = 0;
        for (i = n / 2; i < n; i++) {
            if (num[i] < num[n - i - 1]) {
                num[i] = num[n - i - 1];
                for (j = i + 1; j < n; j++) {
                    num[j] = num[n - j - 1];
                }
                solved = 1;
                break;
            } else if (num[i] > num[n - i - 1]) {
                break;
            }
        }
        if (solved == 1) {
            for (int val : num) {
                ans.add(val);
            }
            return ans;
        } else {
            carry = 1;
            for (i = (n - 1) / 2; i >= 0; i--) {
                if (num[i] + carry == 10) {
                    num[i] = 0;
                    carry = 1;
                } else {
                    num[i]++;
                    carry = 0;
                    break;
                }
            }
            if (carry == 1)
                ans.add(1);
            for (int vl : num)
                ans.add(vl);
            if (carry == 1)
                n++;
            for (i = (n + 1) / 2; i < n; i++)
                ans.set(i, ans.get(n - i - 1));
            return ans;
        }
    }
}
