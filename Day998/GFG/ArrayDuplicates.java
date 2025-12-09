//GFG
//Array Duplicates
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayDuplicates {

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 2, 3};
        System.out.println(findDuplicates(arr));
    }

    public static ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (set.contains(num)) {
                list.add(num);
            } else {
                set.add(num);
            }
        }
        return list;
    }
}
