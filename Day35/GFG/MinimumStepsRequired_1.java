//GFG - Brute force. Solution not accepted as TLE
//Minimum Steps Required
//Time complexity: O(X!) where X is no:of combinations 
//Space complexity: O(1)

package GFG;

public class MinimumStepsRequired_1 {

    public static void main(String[] args) {
        String str = "bbaaabb";
        System.out.println(minSteps(str));
    }

    static int minSteps(String str) {
        // Write your code here
        int n = str.length();
        if (n == 0 || n == 1) {
            return n;
        }

        int minSteps = Integer.MAX_VALUE / 2;
        for (int i = 0; i < n;) {

            int j = i + 1;
            while (j < n && str.charAt(j) == str.charAt(i)) {
                j++;
            }
            String newString = str.substring(0, i) + str.substring(j, str.length());
            minSteps = Math.min(minSteps, 1 + minSteps(newString));
            i = j;
        }
        return minSteps;
    }
}
