//GFG
//Union of Two Sorted Arrays
//Time complexity: O(n+m)
//Space complexity: O(n+m)

package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {
        int n = 5, arr1[] = { 1, 2, 3, 4, 5 };
        int m = 5, arr2[] = { 1, 2, 3, 6, 7 };
        System.out.println(findUnion(arr1, arr2, n, m));
    }

    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        // add your code here
        Set<Integer> resultSet = new HashSet<>();
        for (int x : arr1)
            resultSet.add(x);
        for (int y : arr2)
            resultSet.add(y);

        ArrayList<Integer> ans = new ArrayList<>(resultSet);
        Collections.sort(ans);
        return ans;
    }
}
