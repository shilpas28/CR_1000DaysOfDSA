//GFG
//Closest Three Sum
//Time complexity: O(N^2)
//Space complexity: O(1)

import java.util.Arrays;

public class ClosestThreeSum {

    public static void main(String[] args) {
        int arr[] = { -7, 9, 8, 3, 1, 1 };
        int target = 2;
        System.out.println(threeSumClosest(arr, target));
    }

    static int threeSumClosest(int[] array, int target) {
        // code here
        int diff = Integer.MAX_VALUE, ans = 0;
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            int j = i + 1, k = array.length - 1;
            while (j < k) {
                int sum = array[i] + array[j] + array[k];
                int d = Math.abs(sum - target);
                if (d < diff) {
                    diff = d;
                    ans = sum;
                } else if (d == diff) {
                    ans = Math.max(ans, sum);
                }
                if (sum < target)
                    j++;
                else if (sum == target)
                    return sum;
                else
                    k--;
            }
        }
        return ans;
    }
}
