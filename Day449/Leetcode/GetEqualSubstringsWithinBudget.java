//Leetcode
//1208. Get Equal Substrings Within Budget - Prefix sum and binary search
//Time complexity: O(n logn), we call binary search for every character in s which is O(n) * O(logn) = O(n logn)
//Space complexity: O(n) since we creating array costs of size n

package Leetcode;

public class GetEqualSubstringsWithinBudget {

    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        System.out.println(equalSubstring(s, t, maxCost));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] costs = new int[len + 1];
        costs[0] = 0;
        for (int ind = 1; ind <= len; ind++) {
            costs[ind] = costs[ind - 1] + Math.abs(s.charAt(ind - 1) - t.charAt(ind - 1));
        }

        int res = 0;
        for (int right_index = 1; right_index <= len; right_index++) {
            int min_left = binarySearch(costs, costs[right_index] - maxCost);
            if (right_index - min_left > res) {
                res = right_index - min_left;
            }
        }
        return res;
    }

    static int binarySearch(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
