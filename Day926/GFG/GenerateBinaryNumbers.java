//GFG
//Generate Binary Numbers
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;

public class GenerateBinaryNumbers {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(generateBinary(n));
    }

    public static ArrayList<String> generateBinary(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(Integer.toBinaryString(i));
        }

        return res;
    }
}