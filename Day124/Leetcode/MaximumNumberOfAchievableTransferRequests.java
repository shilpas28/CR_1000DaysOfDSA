//Leetcode
//1601. Maximum Number of Achievable Transfer Requests
//Time complexity:
//Space complexity:

package Leetcode;

public class MaximumNumberOfAchievableTransferRequests {

    public static void main(String[] args) {
        int n = 5;
        int[][] requests = { { 0, 1 }, { 1, 0 }, { 0, 1 }, { 1, 2 }, { 2, 0 }, { 3, 4 } };
        MaximumNumberOfAchievableTransferRequests req = new MaximumNumberOfAchievableTransferRequests();
        System.out.println(req.maximumRequests(n, requests));
    }

    int max = 0;

    public int maximumRequests(int n, int[][] requests) {
        helper(requests, 0, new int[n], 0);
        return max;
    }

    public void helper(int[][] requests, int index, int[] count, int num) {
        // Traverse all n buildings to see if they are all 0. (means balanced)
        if (index == requests.length) {
            for (int i : count) {
                if (0 != i) {
                    return;
                }
            }
            max = Math.max(max, num);
            return;
        }
        // Choose this request
        count[requests[index][0]]++;
        count[requests[index][1]]--;
        helper(requests, index + 1, count, num + 1);
        count[requests[index][0]]--;
        count[requests[index][1]]++;
        // Not Choose the request
        helper(requests, index + 1, count, num);
    }

}
