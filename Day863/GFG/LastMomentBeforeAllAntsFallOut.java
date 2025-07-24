//GFG
//Last Moment Before All Ants Fall Out
//Time complexity: O(n+m)
//space complexity: O(1)

public class LastMomentBeforeAllAntsFallOut {

    public static void main(String[] args) {
        int n = 4;
        int left[] = { 2 };
        int right[] = { 0, 1, 3 };
        System.out.println(getLastMoment(n, left, right));
    }

    public static int getLastMoment(int n, int left[], int right[]) {
        // code here
        int maxTime = 0;
        // For ants moving left, they need 'position' time to reach the left end (0)
        for (int pos : left) {
            maxTime = Math.max(maxTime, pos);
        }
        // For ants moving right, they need 'n - position' time to reach the right end
        // (n)
        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos);
        }
        return maxTime;
    }
}
