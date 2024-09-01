//GFG
//Max sum path in two arrays
//Time complexity: O(m + n)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;
import java.util.List;

public class MaxSumPathInTwoArrays {

    public static void main(String[] args) {

        List<Integer> arr1 = new ArrayList<>();
        arr1.add(2);
        arr1.add(3);
        arr1.add(7);
        arr1.add(10);
        arr1.add(12);
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(5);
        arr2.add(7);
        arr2.add(8);
        System.out.println(maxPathSum(arr1, arr2));
    }

    public static int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here
        int sum1 = 0, sum2 = 0, i = 0, j = 0, result = 0;

        while (i < arr1.size() || j < arr2.size()) {

            if (j == arr2.size() || (i < arr1.size() && arr1.get(i) < arr2.get(j))) {
                sum1 += arr1.get(i);
                i++;
            } else if (i == arr1.size() || (j < arr2.size() && arr1.get(i) > arr2.get(j))) {
                sum2 += arr2.get(j);
                j++;
            } else {
                result += Math.max(sum1, sum2) + arr1.get(i);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        result += Math.max(sum1, sum2);
        return result;
    }
}
