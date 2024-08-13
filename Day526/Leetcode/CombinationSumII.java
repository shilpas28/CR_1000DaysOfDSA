//Leetcode
//40. Combination Sum II
//Time complexity: O(2^n * k) where n is the size of the array, k is the average length
//Space complexity: O(k * x) where x is the no:of combinations (ignoring the auxiliary space used by recursion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > target)
                break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
