//GFG
//Remainder on dividing by 11
//Time complexity: O(length of string x)
//Space complexity: O(1)

package GFG;

public class RemainderOnDividingByEleven_1 {
    public static void main(String[] args) {
        String x = "1345";
        System.out.println(xmod11(x));
    }

    static int xmod11(String x) {
        // code here
        int n = x.length();
        int r = 0;
        for (int i = 0; i < n; i++) {
            int num = r * 10 + (int) (x.charAt(i) - '0');
            r = num % 11;
        }
        return r;
    }
}
