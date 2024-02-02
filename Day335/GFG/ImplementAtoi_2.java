//GFG
//Implement Atoi
//Time complexity: O(|s|)
//Space complexity: O(1)

package GFG;

public class ImplementAtoi_2 {

    public static void main(String[] args) {
        String s = "-123";
        System.out.println(atoi(s));
    }

    static int atoi(String s) {
        // Your code here
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-')
                continue;
            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                num = num * 10 + (s.charAt(i) - '0');
            } else
                return -1;
        }
        if (s.charAt(0) == '-')
            num *= -1;
        return num;
    }
}
