//GFG
//Find Only Repetitive Element from 1 to n-1
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.HashSet;

public class FindOnlyRepetitiveElementFrom1ToNMinus1 {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 3, 4 };
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
