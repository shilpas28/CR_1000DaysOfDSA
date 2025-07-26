//GFG
//Majority Element II
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.TreeMap;

public class MajorityElementII {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6 };
        System.out.println(findMajority(arr));
    }

    public static ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        int tot = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for (int n : arr) {
            mp.put(n, mp.getOrDefault(n, 0) + 1);
        }

        for (int k : mp.keySet()) {
            if (tot / 3 < mp.get(k))
                ans.add(k);
        }

        return ans;
    }
}
