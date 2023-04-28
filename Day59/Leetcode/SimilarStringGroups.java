//Leetcode
//839. Similar String Groups
//Time complexity: O(N^2 * M) where N^2 is from one node going on to every other node and M is to check the similarity
//Space complexity: O(N * M) where N is for visited array and M is for N strings to go in recursive stack(each of size M)

package Leetcode;

public class SimilarStringGroups {

    public static void main(String[] args) {
        String[] strs = { "tars", "rats", "arts", "star" };
        System.out.println(numSimilarGroups(strs));
    }

    public static int numSimilarGroups(String[] strs) {
        int groups = 0, n = strs.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < strs.length; i++) {
            if (vis[i])
                continue;
            groups++;
            dfs(i, strs, vis);
        }
        return groups;
    }

    static void dfs(int i, String[] strs, boolean[] vis) {
        vis[i] = true;
        for (int j = 0; j < strs.length; j++) {
            if (vis[j])
                continue;
            if (isSimilar(strs[i], strs[j])) {
                dfs(j, strs, vis);
            }
        }
    }

    static boolean isSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        return (count == 2 || count == 0);
    }
}
