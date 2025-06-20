//Leetcode
//3443. Maximum Manhattan Distance After K Changes - 4 iterations
//Time complexity: O(N)
//Space complexity: O(1) 

public class MaximumManhattanDistanceAfterKChanges {

    public static void main(String[] args) {
        String s = "NWSE";
        int k = 1;
        System.out.println(maxDistance(s, k));
    }

    public static int maxDistance(String s, int k) {
        int ans = 0;
        char[][] dir = new char[][] { { 'N', 'E' }, { 'N', 'W' }, { 'S', 'E' }, { 'S', 'W' } };
        for (char[] d : dir) {
            for (int i = 0, curr = 0, t = k; i < s.length(); ++i) {
                if (s.charAt(i) == d[0] || s.charAt(i) == d[1]) {
                    if (t > 0) {
                        t--;
                        curr++;
                    } else
                        curr--;
                } else
                    curr++;
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }
}
