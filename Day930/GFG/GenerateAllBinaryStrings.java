//GFG
//Generate all binary strings
//Time complexity: O(n * 2^n)
//Space complexity: O(n)

import java.util.ArrayList;

public class GenerateAllBinaryStrings {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(binstr(n));
    }

    public static ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        if (n <= 0)
            return res;

        char[] cur = new char[n];
        generate(0, n, cur, res);
        return res;
    }

    static void generate(int idx, int n, char[] cur, ArrayList<String> res) {
        if (idx == n) {
            res.add(new String(cur));
            return;
        }

        cur[idx] = '0';
        generate(idx + 1, n, cur, res);

        cur[idx] = '1';
        generate(idx + 1, n, cur, res);
    }
}
