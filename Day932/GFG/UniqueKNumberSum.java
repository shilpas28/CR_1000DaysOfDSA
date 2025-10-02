//GFG
//Unique K-Number Sum
//Time complexity: O(k * 2^9)
//Space complexity: O(k)

import java.util.ArrayList;

public class UniqueKNumberSum {

    public static void main(String[] args) {
        int n = 9, k = 3;
        System.out.println(combinationSum(n, k));
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), 1, k, n, res);
        return res;
    }

    static void dfs(ArrayList<Integer> sofar, int start, int k, int n, ArrayList<ArrayList<Integer>> res) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(sofar));
            return;
        }
        if (k > 0) {
            for (int i = start; i <= 9; i++) {
                if (i > n)
                    break;
                sofar.add(i);
                dfs(sofar, i + 1, k - 1, n - i, res);
                sofar.remove(sofar.size() - 1);
            }
        }
    }
}
