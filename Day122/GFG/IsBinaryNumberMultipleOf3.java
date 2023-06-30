//GFG
//Is Binary Number Multiple of 3
//Time complexity: O(|S|)
//Space complexity: O(1)

package GFG;

public class IsBinaryNumberMultipleOf3 {

    public static void main(String[] args) {
        String S = "0011";
        System.out.println(isDivisible(S));
    }

    static int isDivisible(String s) {
        // code here
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (i % 2 == 0) {
                    sum += 1;
                } else {
                    sum += 2;
                }
            }
        }
        return sum % 3 == 0 ? 1 : 0;
    }
}
