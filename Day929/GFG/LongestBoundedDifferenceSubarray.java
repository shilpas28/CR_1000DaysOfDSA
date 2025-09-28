//GFG
//Longest Bounded-Difference Subarray
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LongestBoundedDifferenceSubarray {

    public static void main(String[] args) {
        int arr[] = { 8, 4, 5, 6, 7 };
        int x = 3;
        System.out.println(longestSubarray(arr, x));
    }

    public static ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        Deque<Integer> maxDq = new LinkedList<>();
        Deque<Integer> minDq = new LinkedList<>();
        int str = 0, maxLen = 0, ansStr = 0;
        for (int end = 0; end < arr.length; end++) {
            while (!maxDq.isEmpty() && arr[maxDq.peekLast()] <= arr[end]) {
                maxDq.pollLast();
            }
            maxDq.addLast(end);
            while (!minDq.isEmpty() && arr[minDq.peekLast()] >= arr[end]) {
                minDq.pollLast();
            }
            minDq.addLast(end);

            while (arr[maxDq.peekFirst()] - arr[minDq.peekFirst()] > x) {
                str++;
                if (maxDq.peekFirst() < str)
                    maxDq.pollFirst();
                if (minDq.peekFirst() < str)
                    minDq.pollFirst();
            }

            if (end - str + 1 > maxLen) {
                maxLen = end - str + 1;
                ansStr = str;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = ansStr; i < ansStr + maxLen; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
