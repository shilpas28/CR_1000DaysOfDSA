//GFG
//Split array in three equal sum subarrays
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class SplitArrayInThreeEqualSumSubarrays {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 0, 4 };
        List<Integer> res = findSplit(arr);
        if (res.get(0) == -1 && res.get(1) == -1)
            System.out.println("false");
        else
            System.out.println("true");
    }

    // Function to determine if array arr can be split into three equal sum sets.
    public static List<Integer> findSplit(int[] arr) {
        // code here
        int n = arr.length, sum = 0;
        List<Integer> ans = new ArrayList<>();
        for (int x : arr)
            sum += x;
        if (sum % 3 != 0) {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        int requiredSum = sum / 3;
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == requiredSum) {
                ans.add(i);
                if (ans.size() == 2)
                    break;
                sum = 0;
            }
        }
        if (ans.size() == 2)
            return ans;
        ans.clear();
        ans.add(-1);
        ans.add(-1);
        return ans;
    }
}
