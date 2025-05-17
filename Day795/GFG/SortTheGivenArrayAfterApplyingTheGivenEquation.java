//GFG
//Sort the given array after applying the given equation - Not accepted as TLE
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Collections;

public class SortTheGivenArrayAfterApplyingTheGivenEquation {

    public static void main(String[] args) {
        int arr[] = { -4, -2, 0, 2, 4 };
        int A = 1, B = 3, C = 5;
        System.out.println(sortArray(arr, A, B, C));
    }

    public static ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : arr) {
            int ele = A * (int) (Math.pow(num, 2)) + B * num + C;
            list.add(ele);
        }

        Collections.sort(list);
        return list;
    }
}
