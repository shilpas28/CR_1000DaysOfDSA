//GFG
//Sorting Elements of an Array by Frequency - Not accepted as TLE
//Time complexity: O(n*logn)
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortingElementsOfAnArrayByFrequency {

    public static void main(String[] args) {
        int arr[] = { 5, 5, 4, 6, 4 };
        System.out.println(sortByFreq(arr));
    }

    // Function to sort the array according to frequency of elements.
    public static ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        int n = arr.length;
        HashMap<Integer, Integer> mm = new HashMap<>();
        int vec[][] = new int[n][2];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : arr)
            mm.put(x, mm.getOrDefault(x, 0) + 1);
        for (int i = 0; i < n; i++) {
            vec[i][0] = arr[i];
            vec[i][1] = mm.get(arr[i]);
        }
        Arrays.sort(vec, new Comparator<int[]>() {
            @Override
            public int compare(int a[], int b[]) {
                if (a[1] != b[1])
                    return b[1] - a[1];
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < n; i++)
            ans.add(vec[i][0]);
        return ans;
    }
}
