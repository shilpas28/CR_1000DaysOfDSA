//GFG
//Minimum Steps Required
//Time complexity: O(N), where N = length of string str
//Space complexity: O(1)

package GFG;

public class MinimumStepsRequired_2 {
    public static void main(String[] args) {
        String str = "bbaaabb";
        System.out.println(minSteps(str));
    }

    static int minSteps(String str) {
        // Write your code here
        int acount = 0;
        int bcount = 0;
        char prev = '#';

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (prev == ch)
                continue;

            if (ch == 'a')
                acount++;
            else
                bcount++;

            prev = ch;
        }
        return Math.min(acount, bcount) + 1;
    }
}
