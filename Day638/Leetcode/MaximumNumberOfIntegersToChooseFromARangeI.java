//Leetcode
//2554. Maximum Number of Integers to Choose From a Range I - HashMap
//Time complexity: O(n+b) (Marking banned numbers + Iterating through range)
//Space complexity: O(b) for the hash map

import java.util.HashSet;

public class MaximumNumberOfIntegersToChooseFromARangeI {

    public static void main(String[] args) {
        int banned[] = { 1, 6, 5 };
        int n = 5, maxSum = 6;
        System.out.println(maxCount(banned, n, maxSum));
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned)
            bannedSet.add(num);
        int total = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (!bannedSet.contains(i)) {
                total += i;
                if (total <= maxSum)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}
