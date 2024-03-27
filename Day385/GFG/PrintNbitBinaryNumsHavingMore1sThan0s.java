//GFG
//Print N-bit binary numbers having more 1s than 0s
//Time complexity: O(2^N)
//Space complexity: O(2^N)

package GFG;

import java.util.ArrayList;
import java.util.Collections;

public class PrintNbitBinaryNumsHavingMore1sThan0s {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(NBitBinary(n));
    }

    static ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        temp.append('1');
        help(ans, 0, 1, temp, N);
        Collections.sort(ans);
        Collections.reverse(ans);
        return ans;
    }

    static void help(ArrayList<String> ans, int zero, int one, StringBuilder temp, int N) {
        if (temp.length() == N) {
            ans.add(temp.toString());
            return;
        }
        if (one > zero) {
            temp.append('0');
            help(ans, zero + 1, one, temp, N);
            temp.deleteCharAt(temp.length() - 1);
        }
        temp.append('1');
        help(ans, zero, one + 1, temp, N);
        temp.deleteCharAt(temp.length() - 1);
    }
}
