//GFG
//Find All Triplets with Zero Sum
//Time complexity: O(N^3)
//Space complexity: O(N^2)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllTripletsWithZeroSum {

    public static void main(String[] args) {
        int arr[] = { 0, -1, 2, -3, 1 };
        System.out.println(findTriplets(arr));
    }

    public static List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(i, j, k);
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }
}
