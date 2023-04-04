//GFG
//Minimum Steps Required
//Time complexity: O(N), where N = length of string str
//Space complexity: O(1)

package GFG;

public class MinimumStepsRequired {

    public static void main(String[] args) {
        String str = "bbaaabb";
        System.out.println(minSteps(str));
    }

    static int minSteps(String str) {
        // Write your code here
        int cnt = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i))
                cnt++;
        }
        if (cnt % 2 != 0)
            return (cnt + 1) / 2 + 1;

        return cnt / 2 + 1;
    }
}
