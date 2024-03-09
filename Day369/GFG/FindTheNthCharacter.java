//GFG
//Find the N-th character
//Time complexity: O(r*|s|)
//Space complexity: O(|s|)

package GFG;

public class FindTheNthCharacter {

    public static void main(String[] args) {
        String s = "1100";
        int r = 2;
        int n = 3;
        System.out.println(nthCharacter(s, r, n));
    }

    public static char nthCharacter(String s, int r, int n) {
        // code here
        StringBuilder temp = new StringBuilder();
        while (r != 0) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1')
                    temp.append("10");
                else
                    temp.append("01");
                if (temp.length() > n)
                    break;
            }
            s = temp.toString();
            temp.setLength(0);
            r--;
        }
        return s.charAt(n);
    }
}
