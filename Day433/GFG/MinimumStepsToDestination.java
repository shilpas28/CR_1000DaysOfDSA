//GFG
//Minimum steps to destination
//Time complexity: O(d)
//Space complexity: O(1)

package GFG;

public class MinimumStepsToDestination {

    public static void main(String[] args) {
        int d = 10;
        System.out.println(minSteps(d));
    }

    static int minSteps(int d) {
        // code here
        int temp = 0, ans = 0;
        while (temp < d) {
            ans++;
            temp += ans;
        }
        if (temp == d)
            return ans;
        int diff = temp - d;
        if (diff % 2 == 0)
            return ans;
        return ans % 2 == 0 ? ans + 1 : ans + 2;
    }
}
