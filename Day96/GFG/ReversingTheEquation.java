//GFG
//Reversing The Equation
//Time complexity: O(|S|)
//Space complexity: O(|S|)

public class ReversingTheEquation {

    public static void main(String[] args) {
        String S = "20-3+5*2";
        System.out.println(reverseEqn(S));
    }

    static String reverseEqn(String S) {
        // your code here
        int i = S.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (i >= 0) {
            int num = (int) (S.charAt(i) - '0');
            int j = i - 1;
            int pow = 1;
            while (j >= 0 && S.charAt(j) >= '0' && S.charAt(j) <= '9') {
                num += (int) (S.charAt(j) - '0') * Math.pow(10, pow);
                pow++;
                j--;
            }
            ans.append(Integer.toString(num));
            while (j >= 0 && (S.charAt(j) < '0' || S.charAt(j) > '9')) {
                ans.append(S.charAt(j));
                j--;
            }
            i = j;
        }
        return ans.toString();
    }
}
